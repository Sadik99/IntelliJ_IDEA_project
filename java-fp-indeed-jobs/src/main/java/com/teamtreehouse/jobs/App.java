package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        JobService service = new JobService();
        boolean shouldRefresh = false;
        try {
            if (shouldRefresh) {
                service.refresh();
            }
            List<Job> jobs = service.loadJobs();
            System.out.printf("Total jobs:  %d %n %n", jobs.size());
            explore(jobs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void explore(List<Job> jobs) {


        MyFunctionalInterface myFunctionalInterface = (v1, v2) -> v1 + " " + v2;
        String myNewString = myFunctionalInterface.concatinate("Brain ", "Station 23");
        System.out.println(myNewString);

        System.out.println("debugging......!!!!!");
        printPortlandJobs(jobs);
        System.out.println();
        threeJuniorJobs(jobs);
        getCaptionStream(jobs).forEach(System.out::println);
        Stream.of("hello", "this", "is", "a", "stream").forEach(System.out::println);
        getSnippetWordCountsImperatively(jobs)
                .forEach((key, value) -> System.out.printf("%s occur %d times %n", key, value));

        IntPredicate intPredicate = k -> k <= 3;

        System.out.println(IntStream.of(1, 2, 3, 4, 5)
                .filter(intPredicate).average());
        System.out.println(jobs.stream()
                .map(Job::getCompany)
                .max(Comparator.comparingInt(String::length)));

        String searchTerm = "Java";
        Optional<Job> foundJob = luckySearchJob(jobs, searchTerm);
        // foundJob.ifPresent(job -> System.out.println(job.getTitle()));
        System.out.println(foundJob.map(Job::getTitle)
                .orElse("No Jobs found!!"));
        List<String> companies = jobs.stream()
                .map(Job::getCompany)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        //  displayCompaniesMenuImperatively(companies);
        displayCompaniesMenuUsingRange(companies);
        System.out.println(companies.size());
        int pageSize = 20;
        int numPages = companies.size() / pageSize;
        IntStream.iterate(1, i -> +pageSize)
                .mapToObj(i -> String.format("%d. %s", i, companies.get(i)))
                .limit(numPages).forEach(System.out::println);
        companies.stream()
                .peek(company -> System.out.println("=====>" + company))
                .filter(company -> company.startsWith("N"))
                .forEach(System.out::println);
        Job firstOne = jobs.get(0);
        System.out.println("First job: " + firstOne);
        // emailIfMatches(firstOne,job -> job.getState().equals("CA"));
        Predicate<Job> caJobChecker = job -> job.getState().equals("CA");
        Job caJob = jobs.stream()
                .filter(caJobChecker)
                .findFirst()
                .orElseThrow(NullPointerException::new);
        emailIfMatches(firstOne, caJobChecker);
        emailIfMatches(caJob, caJobChecker.and(App::isJunior));
        Function<String, LocalDateTime> indeedDateConverter =
                dateString -> LocalDateTime.parse(dateString, DateTimeFormatter.RFC_1123_DATE_TIME);
        Function<LocalDateTime, String> siteDateStringConverter =
                date -> date.format(DateTimeFormatter.ofPattern("M/ d/ yy"));
        jobs.stream()
                .map(Job::getDateTimeString)
                .map(indeedDateConverter.andThen(siteDateStringConverter))
                .limit(5)
                .forEach(System.out::println);
        Function<String, String> converter = createDateStringConverter(
                DateTimeFormatter.RFC_1123_DATE_TIME,
                DateTimeFormatter.ISO_DATE);
        jobs.stream()
                .map(Job::getDateTimeString)
                .map(converter)
                .forEach(System.out::println);
    }

    public static Function<String, String> createDateStringConverter(
            DateTimeFormatter inFormatter,
            DateTimeFormatter outFormatter) {
        final int[] meaningOfLife = {42};
        return dateString -> {
            meaningOfLife[0]++;
            return meaningOfLife[0] + "=======>" + LocalDateTime.parse(dateString, inFormatter)
                    .format(outFormatter);
        };
    }

    public static void emailIfMatches(Job job, Predicate<Job> checker) {
        if (checker.test(job)) {
            System.out.println("I am sending an email about " + job);
        }
    }

    private static void displayCompaniesMenuImperatively(List<String> companies) {
        for (int i = 0; i < 20L; i++) {
            System.out.printf("%d %s %n", i + 1, companies.get(i));
        }
    }

    private static void displayCompaniesMenuUsingRange(List<String> companies) {
        IntStream.rangeClosed(1, 20)
                .mapToObj(i -> String.format("%d. %s", i, companies.get(i - 1)))
                .forEach(System.out::println);
    }

    private static Optional<Job> luckySearchJob(List<Job> jobs, String searchTerm) {
        return jobs.stream()
                .filter(job -> job.getTitle().contains(searchTerm))
                .findFirst();
    }

    public static Map<String, Long> getSnippetWordCountsStream(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getSnippet)
                .map(snippet -> snippet.split("\\w+"))
                .flatMap(Stream::of)
                .filter(word -> word.length() > 0)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    public static Map<String, Long> getSnippetWordCountsImperatively(List<Job> jobs) {
        Map<String, Long> wordCounts = new HashMap<>();
        for (Job job : jobs) {
            String[] words = job.getSnippet().split("\\w+");
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                String lWord = word.toLowerCase();
                Long count = wordCounts.get(lWord);
                if (count == null) {
                    count = 0L;
                }
                wordCounts.put(lWord, count++);

            }
        }
        return wordCounts;
    }

    private static void threeJuniorJobs(List<Job> jobs) {
        jobs.stream()
                .filter(App::isJunior).limit(3)
                .forEach(System.out::println);
    }

    private static boolean isJunior(Job job) {

        if ((job.getTitle().toLowerCase()).contains("junior")
                || (job.getTitle().toLowerCase()).contains("jr")) return true;
        return false;
    }

    private static void printPortlandJobs(List<Job> jobs) {
        jobs.stream()
                .filter(job -> job.getState().equals("OR"))
                .filter(job -> job.getCity().equals("Portland"))
                .forEach(System.out::println);
    }

    private static List<Object> getCaptionStream(List<Job> jobs) {
        return jobs.stream()
                .filter(App::isJunior)
                .map(Job::getCaption)
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<String> getCaptionImperative(List<Job> jobs) {
        List<String> captions = new ArrayList<>();
        for (Job job : jobs) {
            if (isJunior(job)) {

                captions.add(job.getCaption());
                if (captions.size() >= 3) {
                    break;
                }
            }
        }
        return captions;
    }

}
