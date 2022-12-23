interface AutoInterface {
    String NewFunction();
}

class AutoDecorator implements AutoInterface {
    private final AutoInterface auto;

    public AutoDecorator(AutoInterface auto) {
        this.auto = auto;
    }

    public String NewFunction() {
        return auto.NewFunction();
    }

}

class AdditionalCriteria extends AutoDecorator {
    public AdditionalCriteria(AutoInterface auto) {
        super(auto);
    }

    @Override
    public String NewFunction() {
        String improve = super.NewFunction();
        improve += "+ additional criteria\n";
        return improve;
    }
}

class AdditionalCriteria2 extends AutoDecorator {
    public AdditionalCriteria2(AutoInterface auto) {
        super(auto);
    }

    @Override
    public String NewFunction() {
        String improve = super.NewFunction();
        improve += "+ additional criteria 2\n";
        return improve;
    }
}