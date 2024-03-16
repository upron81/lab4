package lab1;

class Detail {
    private String form;
    private String material;
    private double weight;
    private double size;
    protected static String name;

    public Detail(String form, String material, double weight, double size) {
        this.form = form;
        this.material = material;
        this.weight = weight;
        this.size = size;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

class Bolt extends Detail {
    static {
        name = "Bolt";
    }

    public Bolt(String form, String material, double weight, double size) {
        super(form, material, weight, size);
    }
}

class Gear extends Detail {
    static {
        name = "Gear";
    }

    public Gear(String form, String material, double weight, double size) {
        super(form, material, weight, size);
    }
}

class Assembly {
    private Bolt bolt;
    private Gear gear;
    private final String name;

    public Assembly(String name, String boltForm, String boltMaterial, String gearForm, String gearMaterial) {
        this.name = name;
        this.bolt = new Bolt(boltForm, boltMaterial, 10.0, 15.0);
        this.gear = new Gear(gearForm, gearMaterial, 20.0, 25.0);
    }

    public Bolt getBolt() {
        return bolt;
    }

    public Gear getGear() {
        return gear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Assembly: " + name;
    }
}
