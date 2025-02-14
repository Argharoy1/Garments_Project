package com.mycompany.garments;



import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    Garment(String id,String name,String description,String size,String color,double price,int stockQuantity){
        this.id=id;
        this.name=name;
        this.description=description;
        this.size=size;
        this.color=color;
        this.price=price;
        this.stockQuantity=stockQuantity;
    }
    
    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return discount;
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;
    
    Fabric(String id,String type,String color,double pricePerMeter){
        
        this.id=id;
        this.type=type;
        this.color=color;
        this.pricePerMeter=pricePerMeter;
    }

    double calculateCost(double meters) {
        double newPrice = pricePerMeter * meters;
        return newPrice;
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    //List
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        for (Garment g : garments) {
            totalAmount = totalAmount + g.price;
        }
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;
    
    Customer(String customerId,String name,String email,String phone){
     this.customerId=customerId;
     this.name=name;
     this.email=email;
     this.phone=phone;
    }

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }

//    List<Order> viewOrders() {
//        
//    }
}

class Inventory {

    List<Garment> garments;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.remove(id);
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if(g.id == id)
                return g;
        }
        return null;
    }
}

public class  Garments {

    public static void main(String[] args) {
        Garment g1 = new Garment( "34_26","Aj","description","size","color",566.00,40000);
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price= 600;
        double x = g1.calculateDiscountPrice(10);
        System.out.println(x);
        
        Fabric f1=new Fabric("String id","String type","String color",22.0);
        double y= f1.calculateCost(22.00);
        System.out.println(y);
        
        Customer c1 = new Customer("customerId","Argha","email","01676******");
       // c1.placeOrder(order);

    }

}

