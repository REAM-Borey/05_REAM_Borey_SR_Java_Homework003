import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static List<StaffMember> staffMember = new ArrayList<>();
    static Volunteer volunteer;
    static String GREEN = "\u001B[32m";
    static void showMenu(){

        Table table = new Table(1, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);

        table.setColumnWidth(0, 50, 50);


        table.addCell("STAFF MANAGEMENT SYSTEM",cellStyle);
        table.addCell("1. Add Employee");
        table.addCell("2. Update Employee");
        table.addCell("3. Display Employee");
        table.addCell("4. Remove Employee");
        table.addCell("5. Exit");
        System.out.println(table.render());
    }

    static Scanner sc = new Scanner(System.in);

    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static int id = 0;
    static String input,name,address,salary,employeeBonus;
    static void insert(){
        System.out.println("============ ***Insert Employee*** ==============");
        System.out.println("Choose type :");
        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        table.addCell("1. Volunteer" ,cellStyle);
        table.addCell("2. Salaries Employee" ,cellStyle);
        table.addCell("3. Hourly Employee",cellStyle);
        table.addCell("4. Back",cellStyle);
        System.out.println(table.render());

        while (true){
            boolean checkVolunteerSalary=false,checkVolunteerName=false,checkVolunteerAddress=false;
            System.out.print("Enter type number :");
            input = sc.nextLine();
            boolean validInput = Pattern.matches("[1-4]", input);
            if (validInput){
                if (input.equals("1")){
                    System.out.println("Enter id :"+ ++id);
                    while (true){
                        System.out.print("===> Enter Volunteer Name :");
                        name = sc.nextLine();
                        checkVolunteerName = Pattern.matches("[a-zA-Z\\s]+", name);
                        if (checkVolunteerName){
                            break;
                        }
                        System.out.println(RED+"Please input volunteer name again??????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Volunteer Address :");
                        address = sc.nextLine();
                        checkVolunteerAddress = Pattern.matches("[a-zA-Z\\s]+", address);
                        if (checkVolunteerAddress){
                            break;
                        }
                        System.out.println(RED+"Please input volunteer address again?????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Volunteer Salary :");
                        salary = sc.nextLine();
                        checkVolunteerSalary = Pattern.matches("^([1-9]{1})([0-9]+)", salary);
                        if (checkVolunteerSalary){
                            break;
                        }
                        System.out.println(RED+"Please input volunteer salary again?????:"+RESET);
                    }
                    staffMember.add(new Volunteer(id, name, address, Double.parseDouble(salary)));
                } else if (input.equals("2")) {


                    System.out.println("Enter id :"+ ++id);
                    while (true){
                        System.out.print("===> Enter Employee Name :");
                        name = sc.nextLine();
                        checkVolunteerName = Pattern.matches("[a-zA-Z\\s]+", name);
                        if (checkVolunteerName){
                            break;
                        }
                        System.out.println(RED+"Please input employee name again??????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Employee Address :");
                        address = sc.nextLine();
                        checkVolunteerAddress = Pattern.matches("[a-zA-Z\\s]+", address);
                        if (checkVolunteerAddress){
                            break;
                        }
                        System.out.println(RED+"Please input employee address again?????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Employee Salary :");
                        salary = sc.nextLine();
                        checkVolunteerSalary = Pattern.matches("^([1-9]{1})([0-9]+)", salary);
                        if (checkVolunteerSalary){
                            break;
                        }
                        System.out.println(RED+"Please input employee salary again?????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Employee Bonus :");
                        employeeBonus = sc.nextLine();
                        checkVolunteerSalary = Pattern.matches("[0-9]+", employeeBonus);
                        if (checkVolunteerSalary){
                            break;
                        }
                        System.out.println(RED+"Please input employee bonus again?????:"+RESET);
                    }
                    staffMember.add(new SalariedEmployee(id,name,address,Double.parseDouble(salary),Double.parseDouble(employeeBonus)));

                } else if (input.equals("3")) {
                    String hourWork,rate;
                    System.out.println("Enter Hourly Employee id :"+ ++id);
                    while (true){
                        System.out.print("===> Enter Hourly Employee Name :");
                        name = sc.nextLine();
                        checkVolunteerName = Pattern.matches("[a-zA-Z\\s]+", name);
                        if (checkVolunteerName){
                            break;
                        }
                        System.out.println(RED+"Please input employee name again??????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Hourly Employee Address :");
                        address = sc.nextLine();
                        checkVolunteerAddress = Pattern.matches("[a-zA-Z\\s]+", address);
                        if (checkVolunteerAddress){
                            break;
                        }
                        System.out.println(RED+"Please input employee address again?????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Hourly Employee hour work :");
                        hourWork = sc.nextLine();
                        checkVolunteerSalary = Pattern.matches("[0-9]+", hourWork);
                        if (checkVolunteerSalary){
                            break;
                        }
                        System.out.println(RED+"Please input hour work again?????:"+RESET);
                    }
                    while (true){
                        System.out.print("===> Enter Hourly Employee rate :");
                        rate = sc.nextLine();
                        checkVolunteerSalary = Pattern.matches("[0-9]+", rate);
                        if (checkVolunteerSalary){
                            break;
                        }
                        System.out.println(RED+"Please input rate again?????:"+RESET);
                    }

                    staffMember.add(new HourlySalaryEmployee(id,name,address,Integer.parseInt(hourWork),Double.parseDouble(rate)));
                } else if (input.equals("4")) {
                    break;
                }
                if (checkVolunteerAddress && checkVolunteerName && checkVolunteerSalary){
                    System.out.println("=================================================");
                    System.out.println(GREEN+"\t\t\tInset employees is successfully"+RESET);
                    System.out.println("=================================================");
                }
                break;
            }
            System.out.println(RED+"Please enter type number again:"+RESET);
        }



    }






    static void update() {
        System.out.println("==================== Update Employee ====================");

        // Get employee ID input
        String id;
        while (true) {
            System.out.print("Enter Employee ID to search: ");
            id = sc.nextLine();
            if (Pattern.matches("[0-9]+", id)) {
                break;
            }
            System.out.println(RED + "Invalid format for Employee ID! Please enter numbers only." + RESET);
        }

        boolean found = false;
        for (StaffMember sm : staffMember) {
            if (String.valueOf(sm.getStaffId()).equals(id)) {
                found = true;
                while (true) {
                    System.out.println("\n=========== Employee Information ===========");

                    // Create table dynamically based on employee type
                    Table table;
                    if (sm instanceof Volunteer) {
                        table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
                        table.addCell("ID"); table.addCell("NAME");
                        table.addCell("ADDRESS"); table.addCell("SALARY");

                        Volunteer v = (Volunteer) sm;
                        table.addCell(String.valueOf(v.getStaffId()));
                        table.addCell(v.getStaffName());
                        table.addCell(v.getStaffAddress());
                        table.addCell(String.valueOf(v.getSalary()));

                    } else if (sm instanceof SalariedEmployee) {
                        table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
                        table.addCell("ID"); table.addCell("NAME");
                        table.addCell("ADDRESS"); table.addCell("SALARY"); table.addCell("BONUS");

                        SalariedEmployee se = (SalariedEmployee) sm;
                        table.addCell(String.valueOf(se.getStaffId()));
                        table.addCell(se.getStaffName());
                        table.addCell(se.getStaffAddress());
                        table.addCell(String.valueOf(se.getSalary()));
                        table.addCell(String.valueOf(se.getBonus()));

                    } else if (sm instanceof HourlySalaryEmployee) {
                        table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
                        table.addCell("ID"); table.addCell("NAME");
                        table.addCell("ADDRESS"); table.addCell("HOURS WORKED"); table.addCell("RATE");

                        HourlySalaryEmployee he = (HourlySalaryEmployee) sm;
                        table.addCell(String.valueOf(he.getStaffId()));
                        table.addCell(he.getStaffName());
                        table.addCell(he.getStaffAddress());
                        table.addCell(String.valueOf(he.getHourWorked()));
                        table.addCell(String.valueOf(he.getRate()));
                    } else {
                        System.out.println(RED + "Unknown Employee Type!" + RESET);
                        return;
                    }

                    System.out.println(table.render());

                    // Display Update Menu dynamically
                    System.out.println("\n========= Select Option to Update =========");
                    System.out.println();
                    System.out.println("----------------------------------------------");
                    System.out.println("1. Update Name");
                    System.out.println("----------------------------------------------");
                    System.out.println("2. Update Address");

                    if (sm instanceof Volunteer || sm instanceof SalariedEmployee) {
                        System.out.println("----------------------------------------------");
                        System.out.println("3. Update Salary");
                        System.out.println("----------------------------------------------");
                    }
                    if (sm instanceof SalariedEmployee) {

                        System.out.println("4. Update Bonus");
                        System.out.println("----------------------------------------------");
                    }
                    if (sm instanceof HourlySalaryEmployee) {

                        System.out.println("3. Update Hours Worked");
                        System.out.println("----------------------------------------------");
                        System.out.println("4. Update Rate");
                        System.out.println("----------------------------------------------");
                    }

                    System.out.println("5. Cancel");
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter your choice: ");
                    System.out.println("----------------------------------------------");

                    String choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.print("Enter new Name: ");
                            sm.setStaffName(sc.nextLine());
                            line();
                            System.out.println(GREEN + "Name updated successfully!" + RESET);
                            line();
                            break;
                        case "2":
                            System.out.print("Enter new Address: ");
                            sm.setStaffAddress(sc.nextLine());
                            line();
                            System.out.println(GREEN + "Address updated successfully!" + RESET);
                            line();
                            break;
                        case "3":
                            if (sm instanceof Volunteer || sm instanceof SalariedEmployee) {
                                System.out.print("Enter new Salary: ");
                                double salary = Double.parseDouble(sc.nextLine());
                                ((SalariedEmployee) sm).setSalary(salary);
                                line();
                                System.out.println(GREEN + "Salary updated successfully!" + RESET);
                                line();
                            } else if (sm instanceof HourlySalaryEmployee) {
                                System.out.print("Enter new Hours Worked: ");
                                int hours = Integer.parseInt(sc.nextLine());
                                ((HourlySalaryEmployee) sm).setHourWorked(hours);
                                line();
                                System.out.println(GREEN + "Hours Worked updated successfully!" + RESET);
                                line();
                            }
                            break;
                        case "4":
                            if (sm instanceof SalariedEmployee) {
                                System.out.print("Enter new Bonus: ");
                                double bonus = Double.parseDouble(sc.nextLine());
                                ((SalariedEmployee) sm).setBonus(bonus);
                                line();
                                System.out.println(GREEN + "Bonus updated successfully!" + RESET);
                                line();
                            } else if (sm instanceof HourlySalaryEmployee) {
                                System.out.print("Enter new Rate: ");
                                double rate = Double.parseDouble(sc.nextLine());
                                ((HourlySalaryEmployee) sm).setRate(rate);
                                line();
                                System.out.println(GREEN + "Rate updated successfully!" + RESET);
                                line();
                            }
                            break;
                        case "5":
                            line();
                            System.out.println(YELLOW + "Update cancelled!" + RESET);
                            line();
                            return;
                        default:
                            line();
                            System.out.println(RED + "Invalid choice! Please select a valid option." + RESET);
                            line();
                    }
                }
            }
        }

        if (!found) {
            System.out.println(RED + "Employee ID {"+id+"} not found, Please input id employee again: " + RESET);
        }
    }




    static CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

    static void display() {
        System.out.println("============ *** Employee Display *** ==============");

        if (!staffMember.isEmpty()) {
            int pageSize = 5;
            int totalEmployees = staffMember.size();
            int totalPages = (int) Math.ceil((double) totalEmployees / pageSize);
            int currentPage = 1;

            while (true) {

                Table table = new Table(9, BorderStyle.UNICODE_ROUND_BOX);
                table.setColumnWidth(0, 20, 30);
                table.setColumnWidth(1, 10, 30);
                table.setColumnWidth(2, 20, 30);
                table.setColumnWidth(3, 20, 30);
                table.setColumnWidth(4, 10, 30);
                table.setColumnWidth(5, 20, 30);
                table.setColumnWidth(6, 20, 30);
                table.setColumnWidth(7, 10, 30);
                table.setColumnWidth(8, 20, 30);

                table.addCell("TYPE", cellStyle);
                table.addCell("ID", cellStyle);
                table.addCell("NAME", cellStyle);
                table.addCell("ADDRESS", cellStyle);
                table.addCell("SALARY", cellStyle);
                table.addCell("BONUS", cellStyle);
                table.addCell("HOUR", cellStyle);
                table.addCell("RATE", cellStyle);
                table.addCell("PAYMENT", cellStyle);


                int startIdx = (currentPage - 1) * pageSize;
                int endIdx = Math.min(startIdx + pageSize, totalEmployees);

                for (int i = startIdx; i < endIdx; i++) {
                    StaffMember sm = staffMember.get(i);
                    if (sm instanceof Volunteer) {
                        table.addCell("Volunteer", cellStyle);
                        table.addCell(String.valueOf(sm.getStaffId()), cellStyle);
                        table.addCell(sm.getStaffName(), cellStyle);
                        table.addCell(sm.getStaffAddress(), cellStyle);
                        table.addCell(String.valueOf(((Volunteer) sm).getSalary()), cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell(sm.pay() + "", cellStyle);
                    } else if (sm instanceof SalariedEmployee) {
                        table.addCell("Salaried Employee", cellStyle);
                        table.addCell(String.valueOf(sm.getStaffId()), cellStyle);
                        table.addCell(sm.getStaffName(), cellStyle);
                        table.addCell(sm.getStaffAddress(), cellStyle);
                        table.addCell(String.valueOf((((SalariedEmployee) sm).getSalary())), cellStyle);
                        table.addCell(String.valueOf(((SalariedEmployee) sm).getBonus()), cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell(sm.pay() + "", cellStyle);
                    } else if (sm instanceof HourlySalaryEmployee) {
                        table.addCell("Hourly Employee", cellStyle);
                        table.addCell(String.valueOf(sm.getStaffId()), cellStyle);
                        table.addCell(sm.getStaffName(), cellStyle);
                        table.addCell(sm.getStaffAddress(), cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell("---", cellStyle);
                        table.addCell(String.valueOf(((HourlySalaryEmployee) sm).getHourWorked()), cellStyle);
                        table.addCell(String.valueOf(((HourlySalaryEmployee) sm).getRate()), cellStyle);
                        table.addCell(sm.pay() + "", cellStyle);
                    }
                }

                System.out.println(table.render());

                System.out.println();
                System.out.println("\n========= Page " + currentPage + " of " + totalPages + " =========");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("1. First Page \t 2. Next Page \t 3. Previous Page \t 4. Last Page \t 5. Exit");
                System.out.print("Select option: ");
                String option = sc.nextLine();

                if (!Pattern.matches("[1-5]", option)) {
                    System.out.println(RED + "Invalid option, please input again!" + RESET);
                    continue;
                }

                switch (option) {
                    case "1":
                        currentPage = 1;
                        break;
                    case "2":
                        if (currentPage < totalPages) currentPage++;
                        break;
                    case "3":
                        if (currentPage > 1) currentPage--;
                        break;
                    case "4":
                        currentPage = totalPages;
                        break;
                    case "5":
                        return;
                }
            }
        } else {
            System.out.println(RED + "No employee record found!!!!!" + RESET);
        }
    }

    static void remove(){
        System.out.println("====================*********** Remove Employee ************====================");


        String id;
        while (true) {
            System.out.print("Enter Employee ID to remove: ");
            id = sc.nextLine();
            if (Pattern.matches("[0-9]+", id)) {
                break;
            }
            System.out.println(RED + "Invalid format for employee ID! Please enter numbers only." + RESET);
        }

        boolean found = false;
        for (int i = 0; i < staffMember.size(); i++) {
            if (String.valueOf(staffMember.get(i).getStaffId()).equals(id)) {
                found = true;


                System.out.println(YELLOW + "\nAre you sure you want to remove Employee ID [" + id + "]? (yes/no)" + RESET);
                System.out.print("Enter your choice: ");
                String choice = sc.nextLine().trim().toLowerCase();

                if (choice.equals("yes") || choice.equals("y")) {
                    staffMember.remove(i);
                    System.out.println(GREEN + "\nEmployee ID [" + id + "] has been successfully removed!" + RESET);
                } else {
                    System.out.println(YELLOW + "\nEmployee removal cancelled!" + RESET);
                }
                return;
            }
        }

        if (!found) {
            System.out.println(RED + "Employee ID {" + id + "} not found. Please enter a valid employee ID." + RESET);
        }
    }
    static void line(){
        System.out.println("=====================================================================================================");
    }

    public static void main(String[] args) {
        String op;
        while (true){
            while (true) {
                showMenu();
                System.out.print(">>>>>>>>>>>>>Choose an choice: ");
                op = sc.nextLine();
                boolean check = Pattern.matches("[1-5]",op);
                if (check) {
                    break;
                }
                System.out.println(RED+"-------------------------------");
                System.out.println("Invalid option, please input again"+RESET);
            }

            switch (op){
                case "1"->insert();
                case "2"->update();
                case "3"->display();
                case "4"->remove();
                case "5"->System.exit(0);
            }
        }
    }
}