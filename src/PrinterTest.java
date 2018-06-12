import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    @Test
    public void test_lletres_simples() {
        String data =
                " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###\n" +
                "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #\n" +
                "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   # \n" +
                "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #      \n" +
                "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  # ";

        String result;
        Printer p = new Printer(data);

        result =
               " # \n" +
               "# #\n" +
               "###\n" +
               "# #\n" +
               "# #";
        assertEquals(result, p.render("A"));

        result =
                "## \n" +
                "# #\n" +
                "## \n" +
                "# #\n" +
                "## ";
        assertEquals(result, p.render("B"));
        result =
                "# #\n" +
                "# #\n" +
                " # \n" +
                "# #\n" +
                "# #";
        assertEquals(result, p.render("X"));

        result =
                "###\n" +
                "  #\n" +
                " # \n" +
                "   \n" +
                " # ";
        assertEquals(result, p.render("À"));
    }

    @Test
    public void tests_texts() {
        String data =
                " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###\n" +
                "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #\n" +
                "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   # \n" +
                "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #      \n" +
                "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  # ";

        Printer p = new Printer(data);
        String result;

        result =
        "#   ###  ## ### # #\n" +
        "#    #  #   #   # #\n" +
        "#    #  #   ##  # #\n" +
        "#    #  #   #   # #\n" +
        "### ###  ## ### ###";
        assertEquals(result, p.render("Liceu"));

        result =
        "# #  #  ### # #  #  ### ###  #  ###\n" +
        "### # # # # # # # #  #   #  # # # #\n" +
        "### ### # # ### ###  #   #  ### # #\n" +
        "# # # # # # # # # #  #   #  # # # #\n" +
        "# # # # # # # # # #  #   #  # # # #";
        assertEquals(result, p.render("MANHATTAN"));

        result =
        " ##  #  # # ### ###\n" +
        "#   # # ###  #    #\n" +
        "#   ### ###  #   # \n" +
        "#   # # # #  #     \n" +
        " ## # # # # ###  # ";
        assertEquals(result, p.render("CAMIÓ"));
    }

    @Test
    public void tests_texts_amb_espais() {
        String data =
                " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###\n" +
                "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #\n" +
                "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   # \n" +
                "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #      \n" +
                "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  # ";

        Printer p = new Printer(data);
        String result;

        result =
        " #  # # # # ###     ###  #      ##   #  ###     ##  ###  # \n" +
        "# # # # # #  #      #   # #     # # # # # #     # #  #  # #\n" +
        "### # # # #  #      ##  ###     ##  # # # #     # #  #  ###\n" +
        "# # # # # #  #      #   # #     # # # # # #     # #  #  # #\n" +
        "# #  #  ### ###     #   # #     ##   #  # #     ##  ### # #";
        assertEquals(result, p.render("Avui fa bon dia"));

        result =
        " ##  #  ##  ###  ## ### ### ##   ##     ###  ## ### ##   #  ### # #  ##     ### ### ###     ###     ###  ## ##   #  ###  ##\n" +
        "#   # # # #   # #    #  #   # # #       #   #    #  # # # # # # # # #         #   #   #      #      #   #   # # # #  #  #  \n" +
        "#   ### ##   #  #    #  ##  ##   #      ##   #   #  ##  ### # #  #   #       #   #   #       #      ##   #  ##  ###  #   # \n" +
        "#   # # # #     #    #  #   # #   #     #     #  #  # # # # # #  #    #                      #      #     # #   # #  #    #\n" +
        " ## # # # #  #   ##  #  ### # # ##      ### ##   #  # # # # # #  #  ##       #   #   #      ###     ### ##  #   # # ### ## ";
        assertEquals(result, p.render("Caràcters estranys $%# i espais"));
    }

    @Test
    public void tests_altra_font() {
        String data =
        "  _     __    _     __   ___   ___    __                                                    __    __    __    __   ___                                ___   _    \n" +
        " /_|   / _)  / )   /  ) (_    (_     / _   )__/   /      /   /__/  /     /|/|  /| )  /  )  /__)  /  )  /__)  (     /     /  / (  /  (   /  \\_)  (__/   _/    )   \n" +
        "(  |  /(_)  (__   /(_/  /__   /     (__)  /  /   (    (_/   /  )  (__   /   | / |/  (__/  /     (__\\  / (   __)   (     (__/  |_/   |/|/  ( \\    /    /__   .    ";

        Printer p = new Printer(data);
        String result;
        result =
        "                          _     __          _     _                 __   ___    __               ___ \n" +
        " )__/  /  )        )__/  /_|   (           /_|   / )   /  )  /| )  (    (_     / _   /  /   /    /   \n" +
        "/  /  (__/        /  /  (  |  __)         (  |  (__   (__/  / |/  __)   /__   (__)  (__/   (    (    ";
        assertEquals(result, p.render("Ho has aconseguit"));

        result =
        " ___    __    _           __  _     _    \n" +
        "(_     (     / )   /  /  /__)  )     )   \n" +
        "/__   __)   (__   (__/  / (   .     .    ";
        assertEquals(result, p.render("Escurçó"));
    }
}
