    public void drawSpecialSkipDom (Graphics g, double x, double y) {
        Graphics2D g2 = (Graphics2D) g;
        //DRAWING WHITE TAB
        g2.setPaint(yellow);
         
        g2.setStroke(new BasicStroke(3.0f));
        g2.fillRoundRect((int)x, (int)y, 46, WIDTH/15 - 2, 10, 10);
         
        double tabx = x;
        double taby = y;
        double tabWidth = 46;
        //g2.fillRoundRect(x, y, 100, 200, 20, 20);
        //DRAWING BLACK STRIP
        //IF ITS PLAYER 1 DECK
        g.setColor(Color.BLACK);
        g.fillRect((int)tabx,(int) taby + 48, (int)tabWidth, 2);
 
        //SMALL GOLD DOT
        g.setColor(Color.GREEN);
        g.fillOval((int)tabx + 21,(int) taby + 46, 5, 5);
         
    }
