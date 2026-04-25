// Vector Class
class Vector {
    private double[] components;

    // Constructor (Only 2D or 3D allowed)
    public Vector(double[] components) throws VectorException {
        if (components.length != 2 && components.length != 3) {
            throw new VectorException("Only 2D or 3D vectors are allowed.");
        }
        this.components = components;
    }

    public int getDimension() {
        return components.length;
    }

    // Method to check dimension equality
    public void checkDimension(Vector other) throws VectorException {
        if (this.getDimension() != other.getDimension()) {
            throw new VectorException("Vectors must have same dimensions.");
        }
    }

    // Addition
    public Vector add(Vector other) throws VectorException {
        checkDimension(other);

        double[] result = new double[getDimension()];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + other.components[i];
        }
        return new Vector(result);
    }

    // Subtraction
    public Vector subtract(Vector other) throws VectorException {
        checkDimension(other);

        double[] result = new double[getDimension()];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] - other.components[i];
        }
        return new Vector(result);
    }

    // Dot Product
    public double dotProduct(Vector other) throws VectorException {
        checkDimension(other);

        double result = 0;
        for (int i = 0; i < components.length; i++) {
            result += this.components[i] * other.components[i];
        }
        return result;
    }

    // Display Method
    public void display() {
        System.out.print("(");
        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i < components.length - 1)
                System.out.print(", ");
        }
        System.out.println(")");
    }
}