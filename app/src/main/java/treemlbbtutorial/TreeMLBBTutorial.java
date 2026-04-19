package treemlbbtutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMLBBTutorial {

    static class ItemNode {
        String name;
        String note;
        List<ItemNode> children;

        ItemNode(String name, String note) {
            this.name = name;
            this.note = note;
            this.children = new ArrayList<>();
        }

        void addChild(ItemNode child) {
            children.add(child);
        }
    }

    // Print tree structure with indentation
    static void printTree(ItemNode node, int level) {
        if (node == null) return;

        String indent = " ".repeat(level);
        System.out.println(indent + "- " + node.name + " -> " + node.note);

        for (ItemNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    // Print all root-to-leaf paths (complete build orders)
    static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty()) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printAllBuildPaths(child, path);
            }
        }

        path.remove(path.size() - 1);
    }

    // Count total nodes in tree
    static int countNodes(ItemNode node) {
        if (node == null) return 0;

        int total = 1;
        for (ItemNode child : node.children) {
            total += countNodes(child);
        }
        return total;
    }

    // Count leaf nodes (complete builds)
    static int countLeaves(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int total = 0;
        for (ItemNode child : node.children) {
            total += countLeaves(child);
        }
        return total;
    }

    // Calculate tree height
    static int height(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int maxChildHeight = 0;
        for (ItemNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    // Find path to a specific item
    static boolean findPath(ItemNode node, String target, List<String> path) {
        if (node == null) return false;

        path.add(node.name);

        if (node.name.equalsIgnoreCase(target)) {
            return true;
        }

        for (ItemNode child : node.children) {
            if (findPath(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    // TASK 2: Count occurrences of a specific item
    static int countItemOccurrences(ItemNode node, String target) {
        if (node == null) return 0;

        int count = 0;
        if (node.name.equalsIgnoreCase(target)) {
            count = 1;
        }

        for (ItemNode child : node.children) {
            count += countItemOccurrences(child, target);
        }
        return count;
    }

    // TASK 3: Print only paths ending with Immortality
    static void printImmortalityPaths(ItemNode node, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty()) {
            if (node.name.equalsIgnoreCase("Immortality")) {
                System.out.println(String.join(" -> ", path));
            }
        } else {
            for (ItemNode child : node.children) {
                printImmortalityPaths(child, path);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // Build the tree structure
        ItemNode root = new ItemNode("Start Build", "Choose your first major purchase path");

        // === LEFT BRANCH: Windtalker path ===
        ItemNode windtalker = new ItemNode("Windtalker", "Fast farming / tempo path");
        
        ItemNode berserkersFury = new ItemNode("Berserker's Fury", "Higher burst follow-up");
        ItemNode haasClaws = new ItemNode("Haas' Claws", "Lifesteal sustain option");
        
        windtalker.addChild(berserkersFury);
        windtalker.addChild(haasClaws);
        
        ItemNode maleficRoar = new ItemNode("Malefic Roar", "Break tougher enemies later");
        ItemNode windOfNature = new ItemNode("Wind of Nature", "Defensive option versus physical danger");
        
        berserkersFury.addChild(maleficRoar);
        berserkersFury.addChild(windOfNature);
        
        ItemNode bladeOfDespair = new ItemNode("Blade of Despair", "Maximize late damage");
        ItemNode immortality = new ItemNode("Immortality", "Final safety item");
        
        maleficRoar.addChild(bladeOfDespair);
        maleficRoar.addChild(immortality);
        
        ItemNode corrosionScythe = new ItemNode("Corrosion Scythe", "Slow and chase potential");
        haasClaws.addChild(corrosionScythe);
        corrosionScythe.addChild(immortality);
        
        // === RIGHT BRANCH: Demon Hunter Sword path ===
        ItemNode demonHunterSword = new ItemNode("Demon Hunter Sword", "Tank-busting path");
        
        ItemNode goldenStaff = new ItemNode("Golden Staff", "Attack speed cap synergy");
        ItemNode windtalker2 = new ItemNode("Windtalker", "Alternative attack speed option");
        
        demonHunterSword.addChild(goldenStaff);
        demonHunterSword.addChild(windtalker2);
        
        ItemNode corrosionScythe2 = new ItemNode("Corrosion Scythe", "Slow effect for kiting");
        goldenStaff.addChild(corrosionScythe2);
        
        ItemNode bladeOfDespair2 = new ItemNode("Blade of Despair", "Maximum damage output");
        corrosionScythe2.addChild(bladeOfDespair2);
        
        // TASK 1: Add a new branch from Start Build
        ItemNode endlessBattle = new ItemNode("Endless Battle", "Spell vamp / true damage path");
        ItemNode thunderBelt = new ItemNode("Thunder Belt", "Defensive hybrid option");
        ItemNode queensWings = new ItemNode("Queen's Wings", "Damage reduction when low HP");
        
        endlessBattle.addChild(thunderBelt);
        endlessBattle.addChild(queensWings);
        
        ItemNode bruteForceBreastplate = new ItemNode("Brute Force Breastplate", "Movement speed stacking");
        thunderBelt.addChild(bruteForceBreastplate);
        
        // Add all main branches to root
        root.addChild(windtalker);
        root.addChild(demonHunterSword);
        root.addChild(endlessBattle);

        // === OUTPUT SECTION ===
        
        System.out.println("=== TREE STRUCTURE ===");
        printTree(root, 0);
        
        System.out.println("\n=== ALL COMPLETE BUILD PATHS (Root to Leaf) ===");
        printAllBuildPaths(root, new ArrayList<>());
        
        System.out.println("\n=== TREE STATISTICS ===");
        System.out.println("Total nodes: " + countNodes(root));
        System.out.println("Total leaf nodes (complete builds): " + countLeaves(root));
        System.out.println("Tree height: " + height(root));
        
        System.out.println("\n=== SEARCH FOR ITEM ===");
        List<String> pathToCorrosion = new ArrayList<>();
        if (findPath(root, "Corrosion Scythe", pathToCorrosion)) {
            System.out.println("Path to Corrosion Scythe: " + String.join(" -> ", pathToCorrosion));
        } else {
            System.out.println("Corrosion Scythe not found!");
        }
        
        // TASK 2: Count item occurrences
        System.out.println("\n=== TASK 2: ITEM OCCURRENCES ===");
        System.out.println("'Windtalker' appears " + countItemOccurrences(root, "Windtalker") + " time(s)");
        System.out.println("'Blade of Despair' appears " + countItemOccurrences(root, "Blade of Despair") + " time(s)");
        System.out.println("'Immortality' appears " + countItemOccurrences(root, "Immortality") + " time(s)");
        
        // TASK 3: Print Immortality paths
        System.out.println("\n=== TASK 3: PATHS ENDING WITH IMMORTALITY ===");
        printImmortalityPaths(root, new ArrayList<>());
        
        // TASK 4: User input search
        System.out.println("\n=== TASK 4: USER INPUT SEARCH ===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name to search: ");
        String targetItem = scanner.nextLine();
        
        List<String> userPath = new ArrayList<>();
        if (findPath(root, targetItem, userPath)) {
            System.out.println("Found '" + targetItem + "' at path: " + String.join(" -> ", userPath));
        } else {
            System.out.println("'" + targetItem + "' not found in the tree!");
        }
        
        scanner.close();
        
        // TASK 5: Height demonstration
        System.out.println("\n=== TASK 5: HEIGHT DEMONSTRATION ===");
        System.out.println("Current tree height: " + height(root));
    }
}