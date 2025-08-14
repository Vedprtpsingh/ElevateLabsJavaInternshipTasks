package com.ved;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CRUD MENU ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt(sc);
            try {
                switch (choice) {
                    case 1 -> addFlow(sc, dao);
                    case 2 -> viewFlow(dao);
                    case 3 -> updateFlow(sc, dao);
                    case 4 -> deleteFlow(sc, dao);
                    case 5 -> { System.out.println("Goodbye!"); sc.close(); return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println("DB Error: " + e.getMessage());
            }
        }
    }

    private static void addFlow(Scanner sc, UserDAO dao) throws SQLException {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        dao.addUser(new User(name, email));
        System.out.println("✅ User added.");
    }

    private static void viewFlow(UserDAO dao) throws SQLException {
        List<User> users = dao.getAll();
        System.out.println("\n--- Users ---");
        if (users.isEmpty()) System.out.println("(none)");
        users.forEach(System.out::println);
    }

    private static void updateFlow(Scanner sc, UserDAO dao) throws SQLException {
        System.out.print("ID to update: ");
        int id = readInt(sc);
        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New email: ");
        String email = sc.nextLine();
        boolean ok = dao.update(new User(id, name, email));
        System.out.println(ok ? "✅ Updated." : "⚠️ ID not found.");
    }

    private static void deleteFlow(Scanner sc, UserDAO dao) throws SQLException {
        System.out.print("ID to delete: ");
        int id = readInt(sc);
        boolean ok = dao.delete(id);
        System.out.println(ok ? "✅ Deleted." : "⚠️ ID not found.");
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine();
            try { return Integer.parseInt(s.trim()); }
            catch (NumberFormatException e) { System.out.print("Enter a number: "); }
        }
    }
}
