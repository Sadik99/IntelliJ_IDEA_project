const webpack = require('webpack');
const { merge } = require('webpack-merge');
const path = require('path');
const { hashElement } = require('folder-hash');
const MergeJsonWebpackPlugin = require('merge-jsons-webpack-plugin');
const postcssRTLCSS = require('postcss-rtlcss');
const BrowserSyncPlugin = require('browser-sync-webpack-plugin');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const WebpackNotifierPlugin = require('webpack-notifier');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const ESLintPlugin = require('eslint-webpack-plugin');

const environment = require('./environment');
const proxyConfig = require('./proxy.conf');

module.exports = async (config, options, targetOptions) => {
  const languagesHash = await hashElement(path.resolve(__dirname, '../src/main/webapp/i18n'), {
    algo: 'md5',
    encoding: 'hex',
    files: { include: ['*.json'] },
  });

  // PLUGINS
  if (config.mode === 'development') {
    config.plugins.push(
      new ESLintPlugin({
        baseConfig: {
          parserOptions: {
            project: ['../tsconfig.app.json'],
          },
        },
      }),
      new WebpackNotifierPlugin({
        title: 'First Mono App',
        contentImage: path.join(__dirname, 'logo-jhipster.png'),
      })
    );
  }

  // configuring proxy for back end service
  const tls = Boolean(config.devServer && config.devServer.https);
  if (config.devServer) {
    config.devServer.proxy = proxyConfig({ tls });
  }

  if (targetOptions.target === 'serve' || config.watch) {
    config.plugins.push(
      new BrowserSyncPlugin(
        {
          host: 'localhost',
          port: 9000,
          https: tls,
          proxy: {
            target: `http${tls ? 's' : ''}://localhost:${targetOptions.target === 'serve' ? '4200' : '8080'}`,
            ws: true,
            proxyOptions: {
              changeOrigin: false, //pass the Host header to the backend unchanged  https://github.com/Browsersync/browser-sync/issues/430
            },
          },
          socket: {
            clients: {
              heartbeatTimeout: 60000,
            },
          },
          /*
          ghostMode: { // uncomment this part to disable BrowserSync ghostMode; https://github.com/jhipster/generator-jhipster/issues/11116
            clicks: false,
            location: false,
            forms: false,
            scroll: false,
          },
          */
        },
        {
          reload: targetOptions.target === 'build', // enabled for build --watch
        }
      )
    );
  }

  if (config.mode === 'production') {
    config.plugins.push(
      new BundleAnalyzerPlugin({
        analyzerMode: 'static',
        openAnalyzer: false,
        // Webpack statistics in target folder
        reportFilename: '../stats.html',
      })
    );
  }

  const patterns = [
    {
      // https://github.com/swagger-api/swagger-ui/blob/v4.6.1/swagger-ui-dist-package/README.md
      context: require('swagger-ui-dist').getAbsoluteFSPath(),
      from: '*.{js,css,html,png}',
      to: 'swagger-ui/',
      globOptions: { ignore: ['**/index.html'] },
    },
    {
      from: require.resolve('axios/dist/axios.min.js'),
      to: 'swagger-ui/',
    },
    { from: './src/main/webapp/swagger-ui/', to: 'swagger-ui/' },
    // jhipster-needle-add-assets-to-webpack - JHipster will add/remove third-party resources in this array
  ];

  if (patterns.length > 0) {
    config.plugins.push(new CopyWebpackPlugin({ patterns }));
  }

  const scssRule = config.module.rules.find(x => x.test && x.test.toString().includes('scss'));
  const uses = scssRule.rules.flatMap(r => r.use || r.oneOf.flatMap(o => o.use));
  const postcssLoaderOptions = uses.filter(u => u.loader.includes('postcss-loader')).map(u => u.options);
  postcssLoaderOptions.forEach(options => {
    const generateOptions = options.postcssOptions;
    options.postcssOptions = loader => {
      const postcssOptions = generateOptions(loader);
      postcssOptions.plugins.push(postcssRTLCSS());
      return postcssOptions;
    };
    // https://github.com/angular/angular-cli/blob/4b9199d97f3bcb10710b5049b04d8a04436e2dd4/packages/angular_devkit/build_angular/src/webpack/configs/styles.ts#L201-L202
    options.postcssOptions.config = false;
  });

  config.plugins.push(
    new webpack.DefinePlugin({
      I18N_HASH: JSON.stringify(languagesHash.hash),
      // APP_VERSION is passed as an environment variable from the Gradle / Maven build tasks.
      __VERSION__: JSON.stringify(environment.__VERSION__),
      __DEBUG_INFO_ENABLED__: environment.__DEBUG_INFO_ENABLED__ || config.mode === 'development',
      // The root URL for API calls, ending with a '/' - for example: `"https://www.jhipster.tech:8081/myservice/"`.
      // If this URL is left empty (""), then it will be relative to the current context.
      // If you use an API server, in `prod` mode, you will need to enable CORS
      // (see the `jhipster.cors` common JHipster property in the `application-*.yml` configurations)
      SERVER_API_URL: JSON.stringify(environment.SERVER_API_URL),
    }),
    new MergeJsonWebpackPlugin({
      output: {
        groupBy: [
          { pattern: './src/main/webapp/i18n/en/*.json', fileName: './i18n/en.json' },
          { pattern: './src/main/webapp/i18n/al/*.json', fileName: './i18n/al.json' },
          { pattern: './src/main/webapp/i18n/ar-ly/*.json', fileName: './i18n/ar-ly.json' },
          { pattern: './src/main/webapp/i18n/hy/*.json', fileName: './i18n/hy.json' },
          { pattern: './src/main/webapp/i18n/by/*.json', fileName: './i18n/by.json' },
          { pattern: './src/main/webapp/i18n/bn/*.json', fileName: './i18n/bn.json' },
          { pattern: './src/main/webapp/i18n/bg/*.json', fileName: './i18n/bg.json' },
          { pattern: './src/main/webapp/i18n/ca/*.json', fileName: './i18n/ca.json' },
          { pattern: './src/main/webapp/i18n/zh-cn/*.json', fileName: './i18n/zh-cn.json' },
          { pattern: './src/main/webapp/i18n/zh-tw/*.json', fileName: './i18n/zh-tw.json' },
          { pattern: './src/main/webapp/i18n/hr/*.json', fileName: './i18n/hr.json' },
          { pattern: './src/main/webapp/i18n/cs/*.json', fileName: './i18n/cs.json' },
          { pattern: './src/main/webapp/i18n/da/*.json', fileName: './i18n/da.json' },
          { pattern: './src/main/webapp/i18n/nl/*.json', fileName: './i18n/nl.json' },
          { pattern: './src/main/webapp/i18n/et/*.json', fileName: './i18n/et.json' },
          { pattern: './src/main/webapp/i18n/fa/*.json', fileName: './i18n/fa.json' },
          { pattern: './src/main/webapp/i18n/fi/*.json', fileName: './i18n/fi.json' },
          { pattern: './src/main/webapp/i18n/fr/*.json', fileName: './i18n/fr.json' },
          { pattern: './src/main/webapp/i18n/gl/*.json', fileName: './i18n/gl.json' },
          { pattern: './src/main/webapp/i18n/de/*.json', fileName: './i18n/de.json' },
          { pattern: './src/main/webapp/i18n/el/*.json', fileName: './i18n/el.json' },
          { pattern: './src/main/webapp/i18n/hi/*.json', fileName: './i18n/hi.json' },
          { pattern: './src/main/webapp/i18n/hu/*.json', fileName: './i18n/hu.json' },
          { pattern: './src/main/webapp/i18n/in/*.json', fileName: './i18n/in.json' },
          { pattern: './src/main/webapp/i18n/it/*.json', fileName: './i18n/it.json' },
          { pattern: './src/main/webapp/i18n/ja/*.json', fileName: './i18n/ja.json' },
          { pattern: './src/main/webapp/i18n/ko/*.json', fileName: './i18n/ko.json' },
          { pattern: './src/main/webapp/i18n/mr/*.json', fileName: './i18n/mr.json' },
          { pattern: './src/main/webapp/i18n/my/*.json', fileName: './i18n/my.json' },
          { pattern: './src/main/webapp/i18n/pl/*.json', fileName: './i18n/pl.json' },
          { pattern: './src/main/webapp/i18n/pt-br/*.json', fileName: './i18n/pt-br.json' },
          { pattern: './src/main/webapp/i18n/pt-pt/*.json', fileName: './i18n/pt-pt.json' },
          { pattern: './src/main/webapp/i18n/pa/*.json', fileName: './i18n/pa.json' },
          { pattern: './src/main/webapp/i18n/ro/*.json', fileName: './i18n/ro.json' },
          { pattern: './src/main/webapp/i18n/ru/*.json', fileName: './i18n/ru.json' },
          { pattern: './src/main/webapp/i18n/sk/*.json', fileName: './i18n/sk.json' },
          { pattern: './src/main/webapp/i18n/sr/*.json', fileName: './i18n/sr.json' },
          { pattern: './src/main/webapp/i18n/si/*.json', fileName: './i18n/si.json' },
          { pattern: './src/main/webapp/i18n/es/*.json', fileName: './i18n/es.json' },
          { pattern: './src/main/webapp/i18n/sv/*.json', fileName: './i18n/sv.json' },
          { pattern: './src/main/webapp/i18n/tr/*.json', fileName: './i18n/tr.json' },
          { pattern: './src/main/webapp/i18n/ta/*.json', fileName: './i18n/ta.json' },
          { pattern: './src/main/webapp/i18n/te/*.json', fileName: './i18n/te.json' },
          { pattern: './src/main/webapp/i18n/th/*.json', fileName: './i18n/th.json' },
          { pattern: './src/main/webapp/i18n/ua/*.json', fileName: './i18n/ua.json' },
          { pattern: './src/main/webapp/i18n/uz-Cyrl-uz/*.json', fileName: './i18n/uz-Cyrl-uz.json' },
          { pattern: './src/main/webapp/i18n/uz-Latn-uz/*.json', fileName: './i18n/uz-Latn-uz.json' },
          { pattern: './src/main/webapp/i18n/vi/*.json', fileName: './i18n/vi.json' },
          // jhipster-needle-i18n-language-webpack - JHipster will add/remove languages in this array
        ],
      },
    })
  );

  config = merge(
    config
    // jhipster-needle-add-webpack-config - JHipster will add custom config
  );

  return config;
};
