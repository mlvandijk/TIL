public class ServiceDiscovery {

    public static void main(String args[]) {
        try {
            getPortNumber();
        } catch (IOException io) {
            System.out.println("IOEXception");
        }
    }

    private static void getPortNumber() throws IOException {
        Process p = Runtime.getRuntime().exec("docker-compose port selenium 4444", null, new File("your-directory/"));
        try {
            p.waitFor();
        } catch (InterruptedException oops) {
            System.out.println("InterruptedException");
        }
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while((line = error.readLine()) != null){
            System.out.println(line);
        }
        error.close();

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while((line=input.readLine()) != null){
            System.out.println(line);
        }

        input.close();

        OutputStream outputStream = p.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println();
        printStream.flush();
        printStream.close();
    }
}
