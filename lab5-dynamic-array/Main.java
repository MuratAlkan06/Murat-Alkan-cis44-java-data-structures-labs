public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addItem(new Item("Gems"));
        inv.addItem(new Item("Gold"));
        inv.addItem(new Item("Pickaxe"));
        inv.addItem(new Item("Sword"));
        inv.addItem(new Item("Shield"));
        inv.addItem(new Item("Magic Staff"));

        System.out.println("Initial Inventory:");
        inv.display();

        System.out.println("\nCombining 'Sword' and 'Shield':");
        inv.combineItems("Sword", "Shield");

        System.out.println("\nInventory after combination:");
        inv.display();
    }
}
