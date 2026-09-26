import java.util.*;

public class JavaAdventure {

    // =========================================================
    // GAME STATE
    // =========================================================

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static String playerName;

    static int score = 0;
    static int xp = 0;
    static int lives = 3;
    static int streak = 0;
    static int bestStreak = 0;
    static int totalQuestions = 0;
    static int correctAnswers = 0;

    static boolean phase1Complete = false;
    static boolean phase2Complete = false;
    static boolean phase3Complete = false;

    // =========================================================
    // COLORS
    // =========================================================

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String CYAN = "\u001B[36m";
    static final String WHITE = "\u001B[37m";
    static final String BOLD = "\u001B[1m";

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        clearScreen();

        showBanner();

        loading("Initializing Java Adventure");

        System.out.print("\nEnter your name, developer: ");
        playerName = scanner.nextLine().trim();

        if (playerName.isEmpty()) {
            playerName = "Developer";
        }

        clearScreen();

        intro();

        mainMenu();
    }

    // =========================================================
    // BANNER
    // =========================================================

    static void showBanner() {

        System.out.println(CYAN);

        System.out.println("""
                
        ----------------------------------------------------------------------
        
             ██╗ █████╗ ██╗   ██╗ █████╗     █████╗ ██████╗ ██╗   ██╗
             ██║██╔══██╗██║   ██║██╔══██╗   ██╔══██╗██╔══██╗██║   ██║
             ██║███████║██║   ██║███████║   ███████║██║  ██║██║   ██║
        ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║   ██╔══██║██║  ██║██║   ██║
        ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║   ██║  ██║██████╔╝╚██████╔╝
         ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝   ╚═╝  ╚═╝╚═════╝  ╚═════╝
        
                         ⚔ JAVA ADVENTURE ☕
        
        ----------------------------------------------------------------------
        
                       A Java & Spring Boot Quest
        
        ----------------------------------------------------------------------
        """);

        System.out.println(RESET);
    }

    // =========================================================
    // INTRO
    // =========================================================

    static void intro() {

        System.out.println(CYAN);
        System.out.println("==============================================================");
        System.out.println("                    WELCOME, DEVELOPER");
        System.out.println("==============================================================");
        System.out.println(RESET);

        System.out.println("""
        
        You are about to enter the Java Adventure.
        
        Your mission:
        
          ☕ Master Java
          ⚔ Conquer Object-Oriented Programming
          🧠 Survive advanced Java
          🌱 Enter the Spring Boot world
          🚀 Become a Spring Boot Architect
        
        You begin with:
        
          ❤️ Lives: 3
          ⭐ XP: 0
          🏆 Score: 0
          🔥 Streak: 0
        
        Every correct answer earns XP.
        Every wrong answer costs a life.
        
        Lose all your lives and the adventure ends.
        
        """);

        pause();
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    static void mainMenu() {

        while (true) {

            clearScreen();

            showMiniHeader();

            System.out.println();
            System.out.println("Hello, " + playerName + " 👋");
            System.out.println();

            System.out.println("==============================================================");
            System.out.println("                         MAIN MENU");
            System.out.println("==============================================================");

            System.out.println();
            System.out.println("  [1] ⚔ Start Adventure");
            System.out.println("  [2] 🗺 View Phases");
            System.out.println("  [3] 📊 Statistics");
            System.out.println("  [4] 📖 How To Play");
            System.out.println("  [5] 🚪 Exit");

            System.out.println();
            System.out.println("==============================================================");

            System.out.print("\nChoose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    adventure();
                    break;

                case "2":
                    showPhases();
                    break;

                case "3":
                    showStatistics();
                    break;

                case "4":
                    howToPlay();
                    break;

                case "5":
                    exitGame();
                    return;

                default:
                    System.out.println(RED + "\nInvalid choice." + RESET);
                    pause();
            }
        }
    }

    // =========================================================
    // ADVENTURE
    // =========================================================

    static void adventure() {

        while (lives > 0) {

            clearScreen();

            showMiniHeader();

            System.out.println();
            System.out.println("                     ⚔ YOUR ADVENTURE");
            System.out.println();

            System.out.println("  [1] ☕ Java Fundamentals");

            if (phase1Complete) {
                System.out.println("      ✓ COMPLETED");
            } else {
                System.out.println("      🔓 AVAILABLE");
            }

            System.out.println();

            if (phase1Complete) {
                System.out.println("  [2] 🧙 Object-Oriented Java");
                System.out.println("      🔓 AVAILABLE");
            } else {
                System.out.println("  [2] 🔒 Object-Oriented Java");
                System.out.println("      Complete Phase 1 first.");
            }

            System.out.println();

            if (phase2Complete) {
                System.out.println("  [3] ⚡ Advanced Java");
                System.out.println("      🔓 AVAILABLE");
            } else {
                System.out.println("  [3] 🔒 Advanced Java");
                System.out.println("      Complete Phase 2 first.");
            }

            System.out.println();

            if (phase3Complete) {
                System.out.println("  [4] 🌱 Spring Boot");
                System.out.println("      🔓 AVAILABLE");
            } else {
                System.out.println("  [4] 🔒 Spring Boot");
                System.out.println("      Complete Advanced Java first.");
            }

            System.out.println();
            System.out.println("  [5] ↩ Return to Main Menu");

            System.out.println();
            System.out.println("--------------------------------------------------------------");

            System.out.print("\nChoose your destination: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    phase1();
                    break;

                case "2":

                    if (phase1Complete) {
                        phase2();
                    } else {
                        lockedMessage();
                    }

                    break;

                case "3":

                    if (phase2Complete) {
                        phase3();
                    } else {
                        lockedMessage();
                    }

                    break;

                case "4":

                    if (phase3Complete) {
                        phase4();
                    } else {
                        lockedMessage();
                    }

                    break;

                case "5":
                    return;

                default:
                    System.out.println(RED + "\nUnknown destination." + RESET);
                    pause();
            }
        }

        gameOver();
    }

    // =========================================================
    // PHASE 1
    // =========================================================

    static void phase1() {

        clearScreen();

        phaseBanner(
                "PHASE 01",
                "JAVA FUNDAMENTALS",
                "☕"
        );

        Question[] questions = {

                new Question(
                        "Which keyword is used to declare a constant-like variable?",
                        new String[]{"static", "final", "const", "constant"},
                        1
                ),

                new Question(
                        "Which method is the entry point of a standard Java application?",
                        new String[]{"start()", "run()", "main()", "execute()"},
                        2
                ),

                new Question(
                        "Which primitive type stores true or false?",
                        new String[]{"boolean", "bool", "bit", "logical"},
                        0
                ),

                new Question(
                        "Which keyword creates a new object?",
                        new String[]{"create", "object", "new", "instance"},
                        2
                ),

                new Question(
                        "Which type stores text in Java?",
                        new String[]{"Text", "String", "char[] only", "Word"},
                        1
                ),

                new Question(
                        "Which symbol terminates most Java statements?",
                        new String[]{":", ".", ";", ","},
                        2
                ),

                new Question(
                        "Which operator checks equality for primitive values?",
                        new String[]{"=", "==", "===", "equals"},
                        1
                ),

                new Question(
                        "Which keyword exits a loop immediately?",
                        new String[]{"stop", "exit", "break", "returnLoop"},
                        2
                ),

                new Question(
                        "Which primitive type stores decimal numbers such as 10.5?",
                        new String[]{"int", "double", "boolean", "long"},
                        1
                ),

                new Question(
                        "Which keyword is used to make a decision in Java?",
                        new String[]{"when", "if", "check", "condition"},
                        1
                )
        };

        runPhase(questions, 1);
    }

    // =========================================================
    // PHASE 2
    // =========================================================

    static void phase2() {

        clearScreen();

        phaseBanner(
                "PHASE 02",
                "OBJECT-ORIENTED JAVA",
                "🧙"
        );

        Question[] questions = {

                new Question(
                        "Which OOP concept allows one class to inherit another?",
                        new String[]{"Encapsulation", "Inheritance", "Abstraction", "Composition"},
                        1
                ),

                new Question(
                        "Which keyword is used for class inheritance?",
                        new String[]{"implements", "inherits", "extends", "super"},
                        2
                ),

                new Question(
                        "Which keyword refers to the parent class?",
                        new String[]{"parent", "this", "base", "super"},
                        3
                ),

                new Question(
                        "Which concept hides internal implementation details?",
                        new String[]{"Encapsulation", "Inheritance", "Compilation", "Casting"},
                        0
                ),

                new Question(
                        "Which concept allows one interface to have different implementations?",
                        new String[]{"Polymorphism", "Encapsulation", "Inheritance", "Compilation"},
                        0
                ),

                new Question(
                        "What is a blueprint for creating objects?",
                        new String[]{"Method", "Class", "Variable", "Package"},
                        1
                ),

                new Question(
                        "What is an instance of a class?",
                        new String[]{"Object", "Method", "Package", "Constructor"},
                        0
                ),

                new Question(
                        "Which method is automatically called when an object is created?",
                        new String[]{"initializer", "constructor", "builder", "creator"},
                        1
                ),

                new Question(
                        "Which keyword refers to the current object?",
                        new String[]{"self", "current", "this", "object"},
                        2
                ),

                new Question(
                        "Which access modifier provides the most restrictive access?",
                        new String[]{"public", "protected", "private", "default"},
                        2
                )
        };

        runPhase(questions, 2);
    }

    // =========================================================
    // PHASE 3
    // =========================================================

    static void phase3() {

        clearScreen();

        phaseBanner(
                "PHASE 03",
                "ADVANCED JAVA",
                "⚡"
        );

        Question[] questions = {

                new Question(
                        "Which collection does not allow duplicate elements?",
                        new String[]{"List", "Set", "ArrayList", "LinkedList"},
                        1
                ),

                new Question(
                        "Which collection stores key-value pairs?",
                        new String[]{"List", "Set", "Map", "Queue"},
                        2
                ),

                new Question(
                        "Which keyword is used to handle an exception?",
                        new String[]{"catch", "handle", "except", "error"},
                        0
                ),

                new Question(
                        "Which block runs whether an exception occurs or not?",
                        new String[]{"always", "finally", "complete", "finish"},
                        1
                ),

                new Question(
                        "Which interface is commonly used to define a task for a thread?",
                        new String[]{"Runnable", "Threadable", "Executable", "Task"},
                        0
                ),

                new Question(
                        "Which collection maintains insertion order and allows duplicates?",
                        new String[]{"Set", "List", "Map", "HashSet"},
                        1
                ),

                new Question(
                        "What does JVM stand for?",
                        new String[]{
                                "Java Variable Machine",
                                "Java Virtual Machine",
                                "Java Verified Machine",
                                "Java Visual Machine"
                        },
                        1
                ),

                new Question(
                        "What does JDK stand for?",
                        new String[]{
                                "Java Development Kit",
                                "Java Deployment Kit",
                                "Java Developer Kernel",
                                "Java Development Kernel"
                        },
                        0
                ),

                new Question(
                        "Which keyword prevents a method from being overridden?",
                        new String[]{"static", "final", "privateOnly", "constant"},
                        1
                ),

                new Question(
                        "Which feature allows multiple methods with the same name but different parameters?",
                        new String[]{"Overriding", "Overloading", "Inheritance", "Abstraction"},
                        1
                )
        };

        runPhase(questions, 3);
    }

    // =========================================================
    // PHASE 4 - SPRING BOOT
    // =========================================================

    static void phase4() {

        clearScreen();

        phaseBanner(
                "PHASE 04",
                "SPRING BOOT",
                "🌱"
        );

        Question[] questions = {

                new Question(
                        "Which annotation commonly marks the main Spring Boot application class?",
                        new String[]{
                                "@SpringApplication",
                                "@SpringBootApplication",
                                "@BootApplication",
                                "@MainApplication"
                        },
                        1
                ),

                new Question(
                        "Which annotation is commonly used to create a REST controller?",
                        new String[]{
                                "@Controller",
                                "@RestController",
                                "@APIController",
                                "@WebController"
                        },
                        1
                ),

                new Question(
                        "Which annotation maps HTTP GET requests?",
                        new String[]{
                                "@GetMapping",
                                "@GET",
                                "@HttpGet",
                                "@RequestGet"
                        },
                        0
                ),

                new Question(
                        "Which annotation maps HTTP POST requests?",
                        new String[]{
                                "@PostMapping",
                                "@POST",
                                "@HttpPost",
                                "@RequestPost"
                        },
                        0
                ),

                new Question(
                        "Which dependency is commonly used to build REST APIs in Spring Boot?",
                        new String[]{
                                "Spring Web",
                                "Spring Desktop",
                                "Spring Console",
                                "Spring UI"
                        },
                        0
                ),

                new Question(
                        "Which annotation is commonly used for dependency injection?",
                        new String[]{
                                "@InjectBean",
                                "@Autowired",
                                "@Dependency",
                                "@Use"
                        },
                        1
                ),

                new Question(
                        "Which HTTP method is normally used to retrieve data?",
                        new String[]{"POST", "DELETE", "GET", "PATCH"},
                        2
                ),

                new Question(
                        "Which HTTP method is commonly used to create a resource?",
                        new String[]{"GET", "POST", "DELETE", "HEAD"},
                        1
                ),

                new Question(
                        "Which annotation maps a class or method to a URL path?",
                        new String[]{
                                "@RequestMapping",
                                "@URL",
                                "@Path",
                                "@Route"
                        },
                        0
                ),

                new Question(
                        "What is Spring Boot primarily designed to simplify?",
                        new String[]{
                                "Building Spring applications",
                                "Replacing Java",
                                "Creating operating systems",
                                "Writing database engines"
                        },
                        0
                )
        };

        runPhase(questions, 4);
    }

    // =========================================================
    // RUN PHASE
    // =========================================================

    static void runPhase(Question[] questions, int phaseNumber) {

        shuffleQuestions(questions);

        int phaseScore = 0;

        for (int i = 0; i < questions.length; i++) {

            if (lives <= 0) {
                gameOver();
                return;
            }

            Question q = questions[i];

            clearScreen();

            showMiniHeader();

            System.out.println();
            System.out.println("  Phase " + phaseNumber + "   |   Question "
                    + (i + 1) + "/" + questions.length);

            System.out.println();

            showProgressBar(i, questions.length);

            System.out.println();
            System.out.println("  ❤️ Lives: " + lives
                    + "    ⭐ XP: " + xp
                    + "    🏆 Score: " + score
                    + "    🔥 Streak: " + streak);

            System.out.println();
            System.out.println("--------------------------------------------------------------");

            System.out.println();
            System.out.println("  " + q.question);

            System.out.println();

            for (int j = 0; j < q.options.length; j++) {

                System.out.println(
                        "     " + (char) ('A' + j) + ". "
                                + q.options[j]
                );
            }

            System.out.println();
            System.out.println("--------------------------------------------------------------");

            System.out.print("\n  Your answer: ");

            String answer = scanner.nextLine().trim().toUpperCase();

            totalQuestions++;

            if (answer.isEmpty()) {

                System.out.println(RED + "\n  You must choose an answer." + RESET);

                lives--;
                streak = 0;

                pause();
                continue;
            }

            int selected = answer.charAt(0) - 'A';

            if (selected == q.correctAnswer) {

                correctAnswers++;
                score++;
                phaseScore++;

                streak++;

                if (streak > bestStreak) {
                    bestStreak = streak;
                }

                int earnedXP = 10 + (streak * 2);

                xp += earnedXP;

                System.out.println();
                System.out.println(GREEN + """
                        
                         ██████╗ ██████╗ ██████╗ ███████╗ ██████╗████████╗
                        ██╔════╝██╔═══██╗██╔══██╗██╔════╝██╔════╝╚══██╔══╝
                        ██║     ██║   ██║██████╔╝█████╗  ██║        ██║
                        ██║     ██║   ██║██╔══██╗██╔══╝  ██║        ██║
                        ╚██████╗╚██████╔╝██║  ██║███████╗╚██████╗   ██║
                         ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝ ╚═════╝   ╚═╝
                        
                        """ + RESET);

                System.out.println(
                        GREEN + "  + " + earnedXP + " XP" + RESET
                );

                System.out.println(
                        YELLOW + "  🔥 Streak: " + streak + RESET
                );

            } else {

                lives--;
                streak = 0;

                System.out.println();
                System.out.println(RED + "  ✗ WRONG!" + RESET);

                System.out.println(
                        "  Correct answer: "
                                + q.options[q.correctAnswer]
                );

                System.out.println(
                        RED + "  ❤️ Lives remaining: "
                                + lives + RESET
                );
            }

            pause();
        }

        phaseComplete(phaseNumber, phaseScore, questions.length);
    }

    // =========================================================
    // PHASE COMPLETE
    // =========================================================

    static void phaseComplete(
            int phaseNumber,
            int phaseScore,
            int total) {

        if (phaseNumber == 1) {
            phase1Complete = true;
        }

        if (phaseNumber == 2) {
            phase2Complete = true;
        }

        if (phaseNumber == 3) {
            phase3Complete = true;
        }

        clearScreen();

        System.out.println(GREEN);

        System.out.println("""
                
        ==============================================================
                            🏆 PHASE COMPLETE
        ==============================================================
                
                              YOU DID IT!
                
        """);

        System.out.println(RESET);

        System.out.println(
                "        Phase Score: " + phaseScore + "/" + total
        );

        System.out.println(
                "        Total Score: " + score
        );

        System.out.println(
                "        Total XP:    " + xp
        );

        System.out.println(
                "        Best Streak: " + bestStreak
        );

        System.out.println();

        if (phaseNumber < 4) {

            System.out.println(
                    YELLOW
                            + "        🔓 NEW PHASE UNLOCKED!"
                            + RESET
            );

            System.out.println();

            switch (phaseNumber) {

                case 1:
                    System.out.println(
                            "        🧙 OOP is now available."
                    );
                    break;

                case 2:
                    System.out.println(
                            "        ⚡ Advanced Java is now available."
                    );
                    break;

                case 3:
                    System.out.println(
                            "        🌱 Spring Boot is now available."
                    );
                    break;
            }

        } else {

            finalVictory();
        }

        System.out.println();
        pause();
    }

    // =========================================================
    // FINAL VICTORY
    // =========================================================

    static void finalVictory() {

        System.out.println(GREEN);

        System.out.println("""
                
        ==============================================================
                           👑 FINAL BOSS DEFEATED
        ==============================================================
                
                      🌱 SPRING BOOT ARCHITECT 🌱
                
                 YOU HAVE COMPLETED JAVA ADVENTURE!
                
        ==============================================================
        """);

        System.out.println(RESET);

        System.out.println(
                "                 Final Score: " + score
        );

        System.out.println(
                "                 Total XP:    " + xp
        );

        System.out.println(
                "                 Best Streak: " + bestStreak
        );

        System.out.println();

        System.out.println(
                YELLOW + "                 🏆 RANK: "
                        + getRank() + RESET
        );

        System.out.println();
    }

    // =========================================================
    // PHASE LIST
    // =========================================================

    static void showPhases() {

        clearScreen();

        showMiniHeader();

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                         🗺 PHASES");
        System.out.println("==============================================================");

        System.out.println();
        System.out.println("  01 ☕ Java Fundamentals        "
                + status(phase1Complete));

        System.out.println("  02 🧙 Object-Oriented Java     "
                + status(phase2Complete));

        System.out.println("  03 ⚡ Advanced Java             "
                + status(phase3Complete));

        System.out.println("  04 🌱 Spring Boot               "
                + (phase3Complete ? "🔓 AVAILABLE" : "🔒 LOCKED"));

        System.out.println();
        System.out.println("==============================================================");

        pause();
    }

    // =========================================================
    // STATISTICS
    // =========================================================

    static void showStatistics() {

        clearScreen();

        showMiniHeader();

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                       📊 STATISTICS");
        System.out.println("==============================================================");

        System.out.println();

        System.out.println("  Developer       : " + playerName);
        System.out.println("  Rank            : " + getRank());
        System.out.println("  XP              : " + xp);
        System.out.println("  Score           : " + score);
        System.out.println("  Questions       : " + totalQuestions);
        System.out.println("  Correct         : " + correctAnswers);
        System.out.println("  Lives           : " + lives);
        System.out.println("  Current Streak  : " + streak);
        System.out.println("  Best Streak     : " + bestStreak);

        if (totalQuestions > 0) {

            double accuracy =
                    ((double) correctAnswers / totalQuestions) * 100;

            System.out.printf(
                    "  Accuracy        : %.1f%%%n",
                    accuracy
            );
        }

        System.out.println();

        System.out.println("==============================================================");

        pause();
    }

    // =========================================================
    // HOW TO PLAY
    // =========================================================

    static void howToPlay() {

        clearScreen();

        showMiniHeader();

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                      📖 HOW TO PLAY");
        System.out.println("==============================================================");

        System.out.println("""
        
          1. Choose Start Adventure.
        
          2. Begin with Java Fundamentals.
        
          3. Answer each question using A, B, C or D.
        
          4. Correct answers:
                + Score
                + XP
                + Streak
        
          5. Wrong answers:
                - Lose a life
                - Reset your streak
        
          6. Complete a phase to unlock the next one.
        
          7. Eventually you will reach Spring Boot.
        
          8. Complete every phase to become:
        
                    👑 SPRING BOOT ARCHITECT
        
        """);

        pause();
    }

    // =========================================================
    // RANK SYSTEM
    // =========================================================

    static String getRank() {

        if (xp >= 500) {
            return "👑 Spring Boot Architect";
        }

        if (xp >= 350) {
            return "⚔ Java Master";
        }

        if (xp >= 200) {
            return "🔥 Java Warrior";
        }

        if (xp >= 100) {
            return "🧙 Java Apprentice";
        }

        return "🌱 Java Beginner";
    }

    // =========================================================
    // STATUS
    // =========================================================

    static String status(boolean complete) {

        if (complete) {
            return "✓ COMPLETED";
        }

        return "🔓 AVAILABLE";
    }

    // =========================================================
    // PROGRESS BAR
    // =========================================================

    static void showProgressBar(int current, int total) {

        int width = 30;

        int completed =
                (int) (((double) current / total) * width);

        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < width; i++) {

            if (i < completed) {
                bar.append("█");
            } else {
                bar.append("░");
            }
        }

        System.out.println(
                "  [" + bar + "] "
                        + current + "/" + total
        );
    }

    // =========================================================
    // PHASE BANNER
    // =========================================================

    static void phaseBanner(
            String phase,
            String title,
            String emoji) {

        System.out.println(CYAN);

        System.out.println("""
                
        ==============================================================
        
                              %s
                          %s %s
                        
        ==============================================================
        """.formatted(phase, emoji, title));

        System.out.println(RESET);
    }

    // =========================================================
    // MINI HEADER
    // =========================================================

    static void showMiniHeader() {

        System.out.println(CYAN);
        System.out.println(
                "⚔ JAVA ADVENTURE  |  "
                        + playerName
                        + "  |  ⭐ XP: "
                        + xp
        );
        System.out.println(RESET);
    }

    // =========================================================
    // LOCKED MESSAGE
    // =========================================================

    static void lockedMessage() {

        System.out.println();
        System.out.println(YELLOW
                + "🔒 This phase is locked."
                + RESET);

        System.out.println(
                "Complete the previous phase first."
        );

        pause();
    }

    // =========================================================
    // GAME OVER
    // =========================================================

    static void gameOver() {

        clearScreen();

        System.out.println(RED);

        System.out.println("""
                
        ==============================================================
                              💀 GAME OVER
        ==============================================================
                
                       YOUR ADVENTURE HAS ENDED
                
        """);

        System.out.println(RESET);

        System.out.println("  Score       : " + score);
        System.out.println("  XP          : " + xp);
        System.out.println("  Questions   : " + totalQuestions);
        System.out.println("  Correct     : " + correctAnswers);
        System.out.println("  Best Streak : " + bestStreak);

        System.out.println();

        System.out.println(
                YELLOW + "  Rank: " + getRank() + RESET
        );

        System.out.println();
        System.out.println("  Better luck on your next adventure, "
                + playerName + ".");

        System.out.println();

        pause();
    }

    // =========================================================
    // EXIT
    // =========================================================

    static void exitGame() {

        clearScreen();

        System.out.println(CYAN);

        System.out.println("""
                
        ==============================================================
                        
                         ☕ JAVA ADVENTURE
                
                    Thanks for playing, developer.
                
                     Keep coding. Keep learning.
                
        ==============================================================
        """);

        System.out.println(RESET);
    }

    // =========================================================
    // LOADING EFFECT
    // =========================================================

    static void loading(String message) {

        System.out.print(message);

        for (int i = 0; i < 3; i++) {

            sleep(400);

            System.out.print(".");
        }

        System.out.println(" ✓");
    }

    // =========================================================
    // SHUFFLE QUESTIONS
    // =========================================================

    static void shuffleQuestions(Question[] questions) {

        List<Question> list =
                Arrays.asList(questions);

        Collections.shuffle(list);
    }

    // =========================================================
    // PAUSE
    // =========================================================

    static void pause() {

        System.out.println();
        System.out.print("Press ENTER to continue...");

        scanner.nextLine();
    }

    // =========================================================
    // SLEEP
    // =========================================================

    static void sleep(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    // =========================================================
    // CLEAR SCREEN
    // =========================================================

    static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // =========================================================
    // QUESTION CLASS
    // =========================================================

    static class Question {

        String question;
        String[] options;
        int correctAnswer;

        Question(
                String question,
                String[] options,
                int correctAnswer) {

            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }
}