package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    public static final File OBJECTS_FOLDER = join(GITLET_DIR, "objects");

    public static final File HEADS_FOLDER = join(GITLET_DIR, "heads");

    public static final File HEAD_FILE = join(GITLET_DIR, "HEAD");

    public static final File STAGE_FILE = join(GITLET_DIR, "STAGE");
    /* TODO: fill in the rest of this class. */

    public static void Init() {
        if(GITLET_DIR.exists()){
            System.exit(0);
        }
        GITLET_DIR.mkdir();
        OBJECTS_FOLDER.mkdir();
        HEADS_FOLDER.mkdir();
        Utils.writeContents(HEAD_FILE, "");
        Utils.writeContents(STAGE_FILE, "");
    }

    public static void Add(String name) {
        final File fileToAdd = join(CWD, name);
        if(!fileToAdd.exists()){
            System.out.println("File does not exit.");
            System.exit(0);
        }

        byte[] content = readContents(fileToAdd);
        String blobID = sha1(content);

        String head = readObject(HEAD_FILE, String.class);
        Commit headCommit = Commit.fromFile(head);

        
    }
}
