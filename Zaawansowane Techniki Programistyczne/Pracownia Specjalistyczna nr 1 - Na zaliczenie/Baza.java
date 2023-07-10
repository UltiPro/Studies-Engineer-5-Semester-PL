class Baza {

    private char[] tab = new char[100];
    private static Baza object = new Baza();

    public static Baza getBaza() {
        return object;
    }

    public static IPolaczenie getPolaczenie() {
        return Polaczenie.getInstance();
    }

    private static class Polaczenie implements IPolaczenie {

        private Baza baza = Baza.getBaza();
        private static int indexOfPoloczenie = 0;

        private static Polaczenie[] objects = {
                new Polaczenie(),
                new Polaczenie(),
                new Polaczenie(),
                new Polaczenie()
        };

        public static IPolaczenie getInstance() {
            IPolaczenie con = objects[indexOfPoloczenie];
            indexOfPoloczenie = (indexOfPoloczenie + 1) % objects.length;
            return con;
        }

        public char get(int indeks) {
            return baza.tab[indeks];
        }

        public void set(int indeks, char c) {
            baza.tab[indeks] = c;
        }

        public int length() {
            return baza.tab.length;
        }
    }
}