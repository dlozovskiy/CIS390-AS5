
public class MainTest {


    public static void main(String[] args)
    {
        // Setup
        String maze, soln;
        
        Maze sol = new Maze(); 
        // Test a few mazes without portals
        
        System.out.println("\nTEST 1");
        maze = "";
        maze += "##### #\n";
        maze += "#     #\n";
        maze += "# #####\n";
        soln = "";
        soln += "#####o#\n";
        soln += "#ooooo#\n";
        soln += "#o#####\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 2");
        maze = "";
        maze += "##### #\n";
        maze += "#   # #\n";
        maze += "# # # #\n";
        maze += "# #   #\n";
        maze += "# #####\n";
        soln = "";
        soln += "#####o#\n";
        soln += "#ooo#o#\n";
        soln += "#o#o#o#\n";
        soln += "#o#ooo#\n";
        soln += "#o#####\n";
        test(sol.solve(maze).compareTo(soln)==0);
       
        System.out.println("\nTEST 3");
        maze = "";
        maze += "########\n";
        maze += "#      #\n";
        maze += "# ## ###\n";
        maze += "#      #\n";
        maze += "## ## ##\n";
        maze += "#  ##  #\n";
        maze += "## ### #\n";
        maze += "## ### #\n";
        soln = "";
        soln += "########\n";
        soln += "#      #\n";
        soln += "# ## ###\n";
        soln += "# oooo #\n";
        soln += "##o##o##\n";
        soln += "# o##oo#\n";
        soln += "##o###o#\n";
        soln += "##o###o#\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 4");
        maze = "";
        maze += "########\n";
        maze += "#  #    \n";
        maze += "# ## ###\n";
        maze += "#      #\n";
        maze += "# # # ##\n";
        maze += "# ###  #\n";
        maze += "#  ### #\n";
        maze += "## #####\n";
        soln = "";
        soln += "########\n";
        soln += "#  #oooo\n";
        soln += "# ##o###\n";
        soln += "#oooo  #\n";
        soln += "#o# # ##\n";
        soln += "#o###  #\n";
        soln += "#oo### #\n";
        soln += "##o#####\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 5");
        maze = "";
        maze += "# ######\n";
        maze += "#  #   #\n";
        maze += "# ## ###\n";
        maze += "#      #\n";
        maze += "# # # ##\n";
        maze += "# ###  #\n";
        maze += "#  ###  \n";
        maze += "########\n";
        soln = "";
        soln += "#o######\n";
        soln += "#o #   #\n";
        soln += "#o## ###\n";
        soln += "#ooooo #\n";
        soln += "# # #o##\n";
        soln += "# ###oo#\n";
        soln += "#  ###oo\n";
        soln += "########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 6");
        maze = "";
        maze += "########\n";
        maze += "#      #\n";
        maze += "#      #\n";
        maze += "#      #\n";
        maze += "## ## ##\n";
        maze += "## ##  #\n";
        maze += "## ### #\n";
        soln = "";
        soln += "########\n";
        soln += "#      #\n";
        soln += "#      #\n";
        soln += "# oooo #\n";
        soln += "##o##o##\n";
        soln += "##o##oo#\n";
        soln += "##o###o#\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 7");
        maze = "";
        maze += "#########################################################\n";
        maze += "#     #        #  #  #     #  #  #        #     #       #\n";
        maze += "  ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ##  \n";
        maze += "#  #     #  #           #           #  #     #     #  # #\n";
        maze += "#########################################################\n";
        soln = "";
        soln += "#########################################################\n";
        soln += "#oooo #ooooooo #  #  #oooo #  #  #ooooooo #oooo #ooooooo#\n";
        soln += "oo##o##o## ##o## ## ##o##o## ## ##o## ##o##o##o##o## ##oo\n";
        soln += "#  #oooo #  #oooooooooo #oooooooooo #  #oooo #oooo #  # #\n";
        soln += "#########################################################\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 8");
        maze = "";
        maze += "# ######################################\n";
        maze += "#   ###     ##                      ## #\n";
        maze += "### ### ### #  ###### ######## #  # #  #\n";
        maze += "# #     # # ##      #        # #### # ##\n";
        maze += "# ####### # ##### # # ###### # #       #\n";
        maze += "#         #     # # #      # # #  ##   #\n";
        maze += "# ### ### ##### # # ######## # #####   #\n";
        maze += "# ### #     #   ###          # ##    ###\n";
        maze += "#     # ### # ######## #######  # #### #\n";
        maze += "# # # # ### #          ##    ## # ## # #\n";
        maze += "# # # #     ########## #   #### # ## # #\n";
        maze += "# # ##### #          # ### #    #      #\n";
        maze += "# #    ## #######  # # #      # ### ####\n";
        maze += "# #### ##   # # #### # #####  #   # #  #\n";
        maze += "# ## ## ###       ## #       ## # # # ##\n";
        maze += "## # #  ###### ## ## ####### ## # # # ##\n";
        maze += "#  # #       # ##                      #\n";
        maze += "###################################### #\n";
        soln = "";
        soln += "#o######################################\n";
        soln += "#ooo###ooooo##                      ## #\n";
        soln += "###o###o###o#  ###### ######## #  # #  #\n";
        soln += "# #ooooo# #o##      #        # #### # ##\n";
        soln += "# ####### #o##### # # ###### # #       #\n";
        soln += "#         #ooooo# # #      # # #  ##   #\n";
        soln += "# ### ### #####o# # ######## # #####   #\n";
        soln += "# ### #     #ooo###          # ##    ###\n";
        soln += "#     # ### #o######## #######  # #### #\n";
        soln += "# # # # ### #oooooooooo##    ## # ## # #\n";
        soln += "# # # #     ##########o#   #### # ## # #\n";
        soln += "# # ##### #          #o### #    #      #\n";
        soln += "# #    ## #######  # #o#      # ### ####\n";
        soln += "# #### ##   # # #### #o#####  #   # #  #\n";
        soln += "# ## ## ###       ## #ooooooo## # # # ##\n";
        soln += "## # #  ###### ## ## #######o## # # # ##\n";
        soln += "#  # #       # ##           ooooooooooo#\n";
        soln += "######################################o#\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        
        
        // Test mazes with portals
        System.out.println("\nTEST 9");
        maze = "";
        maze += "### #\n";
        maze += "#1#1#\n";
        maze += "# ###\n";
        soln = "";
        soln += "###o#\n";
        soln += "#o#o#\n";
        soln += "#o###\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 10");
        maze = "";
        maze += "######\n";
        maze += " 1##1 \n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oo##oo\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 11");
        maze = "";
        maze += "######\n";
        maze += " 1  1 \n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oo  oo\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 13");
        maze = "";
        maze += "######\n";
        maze += "  1#2 \n";
        maze += "# ####\n";
        maze += "# 2#1#\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oo1#oo\n";
        soln += "#o####\n";
        soln += "#oo#1#\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 14");
        maze = "";
        maze += "# ######\n";
        maze += "#  1  2#\n";
        maze += "########\n";
        maze += "#12    #\n";
        maze += "### ####\n";
        soln = "";
        soln += "#o######\n";
        soln += "#ooo  2#\n";
        soln += "########\n";
        soln += "#ooo   #\n";
        soln += "###o####\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 15");
        maze = "";
        maze += "######\n";
        maze += " 5# 3 \n";
        maze += "######\n";
        maze += "#5  3#\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oo# oo\n";
        soln += "######\n";
        soln += "#oooo#\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 16");
        maze = "";
        maze += "########\n";
        maze += "  0  0  \n";
        maze += "#      #\n";
        maze += "########\n";
        soln = "";
        soln += "########\n";
        soln += "ooo  ooo\n";
        soln += "#      #\n";
        soln += "########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 17");
        maze = "";
        maze += "########\n";
        maze += "  9  9  \n";
        maze += "#      #\n";
        maze += "########\n";
        soln = "";
        soln += "########\n";
        soln += "oooooooo\n";
        soln += "#      #\n";
        soln += "########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 18");
        maze = "";
        maze += "########\n";
        maze += "  9  9  \n";
        maze += "#0    0#\n";
        maze += "########\n";
        soln = "";
        soln += "########\n";
        soln += "oo9  9oo\n";
        soln += "#o    o#\n";
        soln += "########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 19");
        maze = "";
        maze += "######\n";
        maze += "  98  \n";
        maze += "# 89 #\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oooooo\n";
        soln += "# 89 #\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 20");
        maze = "";
        maze += "######\n";
        maze += "1 ## 1\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "o ## o\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 21");
        maze = "";
        maze += "######\n";
        maze += "0 ## 0\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "o ## o\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 22");
        maze = "";
        maze += "######\n";
        maze += "6    6\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "oooooo\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 23");
        maze = "";
        maze += "######\n";
        maze += "4    4\n";
        maze += "######\n";
        soln = "";
        soln += "######\n";
        soln += "o    o\n";
        soln += "######\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 24");
        maze = "";
        maze += "##########\n";
        maze += "# 2#2 6#6#\n";
        maze += "  ######  \n";
        maze += "# 3#3 4#4#\n";
        maze += "##########\n";
        soln = "";
        soln += "##########\n";
        soln += "# 2#2 6#6#\n";
        soln += "oo######oo\n";
        soln += "#oo#ooo#o#\n";
        soln += "##########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 25");
        maze = "";
        maze += "##########\n";
        maze += "# 2#2 6#6#\n";
        maze += "  ### ##  \n";
        maze += "# 3#3 4#4#\n";
        maze += "##########\n";
        soln = "";
        soln += "##########\n";
        soln += "# 2#2 6#6#\n";
        soln += "oo### ##oo\n";
        soln += "#oo#ooo#o#\n";
        soln += "##########\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 26");
        maze = "";
        maze += "#### ####\n";
        maze += "# 6  ####\n";
        maze += "####   0#\n";
        maze += "#### ## #\n";
        maze += "#### ## #\n";
        maze += "#0     6#\n";
        maze += "#### ####\n";
        soln = "";
        soln += "####o####\n";
        soln += "# 6 o####\n";
        soln += "####o  0#\n";
        soln += "####o## #\n";
        soln += "####o## #\n";
        soln += "#0  o  6#\n";
        soln += "####o####\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 27");
        maze = "";
        maze += "#### ####\n";
        maze += "# 0  ####\n";
        maze += "####   6#\n";
        maze += "#### ## #\n";
        maze += "#### ## #\n";
        maze += "#6   0  #\n";
        maze += "#### ####\n";
        soln = "";
        soln += "####o####\n";
        soln += "# ooo####\n";
        soln += "####   6#\n";
        soln += "#### ## #\n";
        soln += "#### ## #\n";
        soln += "#6  oo  #\n";
        soln += "####o####\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 28");
        maze = "";
        maze += "##############\n";
        maze += "# 3        3 #\n";
        maze += "# ########## #\n";
        maze += "              \n";
        maze += "# ########## #\n";
        maze += "#  0      0  #\n";
        maze += "##############\n";
        soln = "";
        soln += "##############\n";
        soln += "# 3        3 #\n";
        soln += "# ########## #\n";
        soln += "oo          oo\n";
        soln += "#o##########o#\n";
        soln += "#ooo      ooo#\n";
        soln += "##############\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        System.out.println("\nTEST 29");
        maze = "";
        maze += "# ######################################\n";
        maze += "#   ###     ##                      ## #\n";
        maze += "### ### ### #  ###### ######## #  # #  #\n";
        maze += "# #    7# #7##      #        # #### # ##\n";
        maze += "# ####### # ##### # # ###### # #       #\n";
        maze += "#         #     # # #      # # #  ##   #\n";
        maze += "# ### ### ##### # # ######## # #####   #\n";
        maze += "# ### #    5#   ###          # ##    ###\n";
        maze += "#     # ### #4######## #######  # #### #\n";
        maze += "# # # # ### #          ##    ## # ## # #\n";
        maze += "# # # #     ########## #   #### # ## # #\n";
        maze += "# # ##### #    4 5   # ### #    #      #\n";
        maze += "# #    ## #######  #3#3#      #1### ####\n";
        maze += "# #### ##   # # #### # #####  #   # #  #\n";
        maze += "# ## ## ###       ## #   2   ## # # # ##\n";
        maze += "## # #  ###### ## ## ####### ##1# # # ##\n";
        maze += "#  # #       # ##         2            #\n";
        maze += "###################################### #\n";
        soln = "";
        soln += "#o######################################\n";
        soln += "#ooo###     ##                      ## #\n";
        soln += "###o### ### #  ###### ######## #  # #  #\n";
        soln += "# #ooooo# #o##      #        # #### # ##\n";
        soln += "# ####### #o##### # # ###### # #       #\n";
        soln += "#         #ooooo# # #      # # #  ##   #\n";
        soln += "# ### ### #####o# # ######## # #####   #\n";
        soln += "# ### #    5#ooo###          # ##    ###\n";
        soln += "#     # ### #o######## #######  # #### #\n";
        soln += "# # # # ### #          ##    ## # ## # #\n";
        soln += "# # # #     ########## #   #### # ## # #\n";
        soln += "# # ##### #    oooooo# ### #    #      #\n";
        soln += "# #    ## #######  #o#o#      #1### ####\n";
        soln += "# #### ##   # # #### #o#####  #   # #  #\n";
        soln += "# ## ## ###       ## #oooo   ## # # # ##\n";
        soln += "## # #  ###### ## ## ####### ##1# # # ##\n";
        soln += "#  # #       # ##         ooooooooooooo#\n";
        soln += "######################################o#\n";
        test(sol.solve(maze).compareTo(soln)==0);
        
        
        System.out.println("Assignment complete.");
    }
    
    public static void test(Boolean a) {
        
        if (a) System.out.println("Match!!!");
        else
        { 
            System.out.println("Fail!"); 
        } 	
        return;
    }
    
    
    
    }