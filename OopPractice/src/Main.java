public class Main {
    public static void main(String[] args) {
        var textBox1= new TextBox();
        var textBox2=textBox1;
        textBox2.setText("Hello SADIK!");
        System.out.println(textBox1.text);
        var employee=new Employee(50000,20);
        int wage=employee.calculateWage(30);
        System.out.println(wage);
        int withoutWage=employee.calculateWage();
        System.out.println(withoutWage);
        var browser= new Browser();
        Employee.printNumberOfEmployees();
        var control= new TextBox();
        control.disable();
        System.out.println(control.isEnabled());
        var box1=new TextBox();
        box1.setText("Override check!");
        //System.out.println(box1.hashCode());
        System.out.println(box1.toString());
        //var controls = new UIControl(true);
       // show(controls);
        show(box1);
        var point1=new Point(1,2);
        var point2=new Point(1,2);
        System.out.println(point1.equals(point2));
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());
        UIControl[] controlss={new TextBox(),new CheckBox()};
        for (var pControl:controlss)
        {
            pControl.render();
        }
        var calculator=new TaxCalculator2022(10000);
        var report=new TaxReport();
        report.show(calculator);
        report.show(new TaxCalculator2023());


    }
    public static void show(UIControl controls)
    {
        if(controls instanceof TextBox) {
            var testBox = (TextBox) controls;
            testBox.setText("Hello Show!");
        }
        System.out.println(controls);
    }

}