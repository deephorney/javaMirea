package six;

public class BuilderExample {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public static class Builder {
        public int a;
        public int b;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;

        public Builder(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Builder c(int val) {
            c = val;
            return this;
        }

        public Builder d(int val) {
            d = val;
            return this;
        }

        public Builder e(int val) {
            e = val;
            return this;
        }

        public Builder f(int val) {
            f = val;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(this);
        }
    }

    private BuilderExample(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
        e = builder.e;
        f = builder.f;
    }

    public static void main(String[] args) {
        BuilderExample good = new BuilderExample.Builder(40, 20)
                .c(2)
                .d(4)
                .e(23)
                .f(9)
                .build();
        System.out.println("D=" + good.d + " F=" + good.f);
        BuilderExample good2 = new BuilderExample.Builder(40, 20)
                .c(2)
                .build();
        System.out.println("C=" + good2.c + " E=" + good2.e);
    }
}
