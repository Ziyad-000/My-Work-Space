package com.mycompany.oopproject;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Minimum 2 shapes are required with type and dimensions.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            System.out.println("Error: Number of shapes must be at least 2.");
            return;
        }

        Drawable[] draws = new Drawable[n];
        int argIndex = 1;

        for (int i = 0; i < n; i++) {
            try {
                if (argIndex >= args.length) {
                    System.out.println("Error: Missing parameters.");
                    break;
                }

                String type = args[argIndex++];
                Drawable shape = null;

                if (type.equalsIgnoreCase("circle")) {
                    if (argIndex >= args.length) {
                        System.out.println("Error: Missing radius for circle.");
                        break;
                    }
                    double radius = Double.parseDouble(args[argIndex++]);
                    if (radius <= 0) {
                        System.out.println("Error: Radius must be greater than 0.");
                        break;
                    }
                    shape = new Circle("red", radius);

                } else if (type.equalsIgnoreCase("cube")) {
                    if (argIndex >= args.length) {
                        System.out.println("Error: Missing side for cube.");
                        break;
                    }
                    double side = Double.parseDouble(args[argIndex++]);
                    if (side <= 0) {
                        System.out.println("Error: Side must be greater than 0.");
                        break;
                    }
                    shape = new Cube("red", side);

                } else {
                    System.out.println("Error: Unknown shape type. Please use 'circle' or 'cube'.");
                    break;
                }

                draws[i] = shape;

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please check your input.");
                break;
            }
        }

        double totalArea = 0;
        for (int i = 0; i < draws.length; i++) {
            if (draws[i] instanceof Circle) {
                Circle crcle = (Circle) draws[i];
                totalArea += crcle.getArea();
            }
            if (draws[i] instanceof Cube) {
                Cube cub = (Cube) draws[i];
                totalArea += cub.getArea();
            }
        }
        System.out.println("Total area of all shapes: " + totalArea);
        
        Main gui = new Main();
        gui.displayAreaSum();
    }

public void displayAreaSum() {
    String arraySizeInput;
    int arraySize = 0;

    // Ensure valid array size input
    while (true) {
        arraySizeInput = JOptionPane.showInputDialog("Enter the number of shapes (circle and cube):");
        if (arraySizeInput == null) { 
            System.exit(0);  
        }

        try {
            arraySize = Integer.parseInt(arraySizeInput);
            if (arraySize <= 0) {
                JOptionPane.showMessageDialog(null, "Error: Number of shapes must be greater than 0. Please try again.");
                continue;
            }
            break;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Invalid input. Please enter a valid integer.");
        }
    }

    Drawable[] shapes = new Drawable[arraySize];
    double totalArea = 0;

    for (int i = 0; i < arraySize; i++) {
        String shapeChoice;

        // Ensure valid shape choice input
        while (true) {
            shapeChoice = JOptionPane.showInputDialog("Enter 'circle' or 'cube' for shape #" + (i + 1) + ":").toLowerCase();
            if (shapeChoice == null) {  
                System.exit(0);  
            }

            if (shapeChoice.equals("circle") || shapeChoice.equals("cube")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error: Invalid shape type. Please enter 'circle' or 'cube'.");
            }
        }

        if (shapeChoice.equals("circle")) {
            double radius = 0;

            // Ensure valid radius input
            while (true) {
                try {
                    String radiusInput = JOptionPane.showInputDialog("Enter the radius for Circle #" + (i + 1) + ":");
                    if (radiusInput == null) {  
                        System.exit(0);  
                    }

                    radius = Double.parseDouble(radiusInput);
                    if (radius <= 0) {
                        JOptionPane.showMessageDialog(null, "Error: Radius must be greater than 0. Please try again.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Invalid input. Please enter a valid number for the radius.");
                }
            }

            shapes[i] = new Circle(radius);
        } else if (shapeChoice.equals("cube")) {
            double side = 0;

            // Ensure valid side length input
            while (true) {
                try {
                    String sideInput = JOptionPane.showInputDialog("Enter the side length for Cube #" + (i + 1) + ":");
                    if (sideInput == null) {  
                        System.exit(0);  
                    }

                    side = Double.parseDouble(sideInput);
                    if (side <= 0) {
                        JOptionPane.showMessageDialog(null, "Error: Side length must be greater than 0. Please try again.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Invalid input. Please enter a valid number for the side length.");
                }
            }

            shapes[i] = new Cube(side);
        }
    }

    for (Drawable shape : shapes) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            totalArea += circle.getArea();
        } else if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            totalArea += cube.getArea();
        }
    }

    JOptionPane.showMessageDialog(null, "The sum of all the areas is: " + totalArea);
}
}