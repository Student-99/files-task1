import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder logs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.out.println("Установка игры myGame");

        File gameDirectory = new File("temp/Game/myGame");

        File srcDir = new File(gameDirectory.getPath() + "/src");
            File mainDir = new File(srcDir.getPath() + "/main");
                File mainDoc = new File(mainDir.getPath()+"/Main.java");
                File utilsDoc = new File(mainDir.getPath()+"/Utils.java");

            File testDir = new File(srcDir.getPath() + "/test");

            File resDir = new File(gameDirectory.getPath() + "/rec");
                File drawablesDir = new File(resDir.getPath()+"/drawables");
                File vectorsDir = new File(resDir.getPath()+"/vectors");
                File iconsDir = new File(resDir.getPath()+"/icons");

            File saveGamesDir = new File(gameDirectory.getPath() + "/saveGames");
            File tempDir = new File(gameDirectory.getPath() + "/temp");
                File log = new File(tempDir.getPath()+"/log.txt");

        createDir(gameDirectory);
            createDir(srcDir);
                createFile(mainDoc);
                createFile(utilsDoc);
            createDir(mainDir);
            createDir(testDir);
            createDir(resDir);
                createDir(drawablesDir);
                createDir(vectorsDir);
                createDir(iconsDir);
            createDir(saveGamesDir);
            createDir(tempDir);
                createFile(log);

        try (FileWriter fileWriter = new FileWriter(log.getPath())){
            fileWriter.write(logs.toString());
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    static void createDir(File file){
        if (!file.exists()) {
                if (file.mkdirs()) {
                    String s =String.format("Создали папку - %s по пути - %s\n",file.getName(),file.getAbsolutePath());
                    System.out.println(s);
                    logs.append(s);
                }

        }
    }

    static void createFile(File file) throws IOException {
        if (!file.exists()){
            if (file.createNewFile()) {
                String s = String.format("Создали файл - %s по пути - %s\n",file.getName(),file.getAbsolutePath());
                System.out.println(s);
                logs.append(s);
            }
        }
    }
}
