public class Vector {

    private static final int LENGTH = 9;
    
    private int[] elements;
    private int numberOfElements;

    public Vector() {
        this.elements = new int[LENGTH];
        this.numberOfElements = LENGTH;
    }

    public void prepare() {
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = i + 1;
        }
    }

    public int returnValueOnIndex(int index) {
        return this.elements[index];
    }

    public int returnNumberOfElements() {
        return this.numberOfElements;
    }

    public void setValue(int index, int value) {
        this.elements[index] = value;
    }

    public void setTo0(int index) {
        this.elements[index - 1] = 0;
    }

    public void remove() {
        for (int i = 0; i < this.elements.length; i++) {
            this.setTo0(i);
        }
    }
}
