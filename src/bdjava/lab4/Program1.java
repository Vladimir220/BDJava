package bdjava.lab4;

import static java.lang.System.out;

public class Program1 {
    public static void main(String[] args) {
        Shop shop = new Shop("Абибас");
        Shop.Department dep = shop.new Department("Зимняя обувь");
        dep.setDescription("ПОлезные вещи для зимы");
        Shop.Product prod = shop.new Product("Сапоги", 2000);
        prod.setDescription("Модные, молодежные");
        prod.setDepartment(dep);
        Shop.Service serv = shop.new Service("Чистка обуви", 300);
        serv.setDescription("Быстро и качественно");
        out.println("-----------");
        out.println("Отдел:");
        out.println(dep);
        out.println("-----------");
        out.println("Товар:");
        out.println(prod);
        out.println("-----------");
        out.println("Услуга:");
        out.println(serv);

    }
}

class Shop {
    private String name;
    class Department {
        private final int ID;
        private final String title;
        private String description;
        private static int numOfDepartaments;
        Department (String title) {
            this.ID = Department.numOfDepartaments;
            Department.numOfDepartaments++;
            this.title = title;
        }
        public int getID() {
            return ID;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        @Override
        public String toString() {
            return ID + "\n" +
                    title + "\n" +
                    description + "\n";
        }
    }
    class Product {
        private final int ID;
        private final String title;
        private int cost;
        private String description;
        private Department department;
        private static int numOfProducts;
        Product (String title) {
            this.ID = Product.numOfProducts;
            Product.numOfProducts++;
            this.title = title;
        }
        Product (String title, int cost) {
            this(title);
            this.cost = cost;
        }
        public void setCost(int cost) {
            this.cost = cost;
        }
        public int getCost() {
            return cost;
        }
        public int getID() {
            return ID;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Department getDepartment() {
            return department;
        }
        public void setDepartment(Department department) {
            this.department = department;
        }
        @Override
        public String toString() {
            return ID + "\n" +
                    title + "\n" +
                    cost + "руб\n" +
                    description + "\n" +
                    department + "\n";
        }
    }
    class Service {
        private final int ID;
        private final String title;
        private int cost;
        private String description;
        private static int numOfServices;
        Service (String title) {
            this.ID = Service.numOfServices;
            Service.numOfServices++;
            this.title = title;
        }
        Service (String title, int cost) {
            this(title);
            this.cost = cost;
        }
        public void setCost(int cost) {
            this.cost = cost;
        }
        public int getCost() {
            return cost;
        }
        public int getID() {
            return ID;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        @Override
        public String toString() {
            return ID + "\n" +
                    title + "\n" +
                    cost + "руб\n" +
                    description + "\n";
        }
    }
    Shop (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}