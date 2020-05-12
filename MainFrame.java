import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Field field;
    private Player first;
    private Player second;
    private Player cuPlayer;
    private int Operation;
    private int turn = 0;
    private JButton[][] buttons;
    private JLabel status;

    public MainFrame(Field field, Player first, Player second) {
        this.field = field;
        this.first = first;
        this.second = second;
        cuPlayer = first;
        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Tic-tac-toe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new FlowLayout());
        createStatusBar();
        createGameField();


    }

    private void createGameField() {
        JPanel fild = new JPanel();
        fild.setPreferredSize(new Dimension(400, 400));
        fild.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        status.setText(cuPlayer.FieldPositions + " Turn");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                int finalI = i;
                int finalJ = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            cuPlayer.currentPlayer(finalI, finalJ);
                            turn++;
                            if (second instanceof AiRandomPlayer && turn < 9){
                                cuPlayer = second;
                                cuPlayer.currentPlayer();
                                turn++;
                            }else if (second instanceof AiRandomPreparedPlayer && turn < 9){
                                cuPlayer = second;
                                cuPlayer.currentPlayer();
                                turn++;
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        updateField();
                        if (cuPlayer.testOnWin(turn) != null) {
                            FildPositions winner = cuPlayer.testOnWin(turn);
                            if (winner == FildPositions.Emptyspace) {
                                status.setText("Nobody Wins");
                                ShowWinner showWinner = new ShowWinner(winner);
                                dispose();
                            } else {
                                status.setText(winner + " Wins");
                                ShowWinner showWinner = new ShowWinner(winner);
                                dispose();
                            }
                        }

                        if (cuPlayer == first) {
                            cuPlayer = second;
                        } else if (cuPlayer == second) {
                            cuPlayer = first;
                        }
                        if (cuPlayer != null) {
                            status.setText(cuPlayer.FieldPositions + " Turn");
                        }
                    }
                });
                fild.add(button);
            }
        }
        add(fild);
    }

    private void updateField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = buttons[i][j];
                if (field.getValue(i, j).equals(FildPositions.Cross)) {
                    button.setText("X");
                } else if (field.getValue(i, j).equals(FildPositions.Zero)) {
                    button.setText("0");
                }

            }
        }
    }

    private void createStatusBar() {

        JPanel statusBar = new JPanel();
        statusBar.setPreferredSize(new Dimension(500, 100));
        statusBar.setLayout(new FlowLayout());
        status = new JLabel("Current status line");
        status.setPreferredSize(new Dimension(200, 100));
        statusBar.add(status);
        JButton button = new JButton();
        button.setText("Settings");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings settings = new Settings();
                dispose();
            }
        });
        statusBar.add(button);
        add(statusBar);
    }


    class ShowWinner extends JFrame {
        public ShowWinner(FildPositions player) {
            setSize(400, 200);
            setLocationRelativeTo(null);
            setTitle("Winner is");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            JPanel jPanel = new JPanel();

            if (player == FildPositions.Emptyspace) {
                JLabel label = new JLabel("NoBoDy wOn");
                label.setSize(400, 400);
                add(label);
            } else {
                JLabel label = new JLabel(player + " YOU WON");
                label.setSize(400, 400);
                add(label);
            }

            JButton button = new JButton();
            button.setText("OK");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Settings settings = new Settings();
                    dispose();
                }
            });
            add(button);
//            add(jPanel);
            setVisible(true);
        }
    }
}
    class Settings extends JFrame {
        public Settings() {
            setSize(300, 200);
            setLocationRelativeTo(null);
            setTitle("Settings");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            setLayout(new FlowLayout());
            add(new JLabel("select game mode"));

            JPanel settingsPanel = new JPanel();
            settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS)); //
            settingsPanel.setPreferredSize(new Dimension(300, 200));
            JButton firstButton = new JButton();
            JButton secondButton = new JButton();
            JButton thirdButton = new JButton();
            JButton fourthButton = new JButton();
            firstButton.setText("Local player vs player");
            secondButton.setText("Local player vs random ai");
            thirdButton.setText("Local player vs stat ai");
            fourthButton.setText("Web player vs player");
            firstButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            secondButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            thirdButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            fourthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            firstButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Field field = new Field(3);
                    PlayerForFrame first = new PlayerForFrame(FildPositions.Cross, field);
                    PlayerForFrame second = new PlayerForFrame(FildPositions.Zero, field);
                    MainFrame mainFrame = new MainFrame(field, first, second);
                    mainFrame.setVisible(true);
                    dispose();
                }
            });
            secondButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Field field = new Field(3);
                    PlayerForFrame first = new PlayerForFrame(FildPositions.Cross, field);
                    AiRandomPlayer second = new AiRandomPlayer(FildPositions.Zero, field);
                    MainFrame mainFrame = new MainFrame(field, first, second);
                    mainFrame.setVisible(true);
                    dispose();
                }
            });
            thirdButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Field field = new Field(3);
                    PlayerForFrame first = new PlayerForFrame(FildPositions.Cross, field);
                    AiRandomPreparedPlayer second = new AiRandomPreparedPlayer(FildPositions.Zero, field);
                    MainFrame mainFrame = new MainFrame(field, first, second);
                    mainFrame.setVisible(true);
                    dispose();
                }
            });
            fourthButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            settingsPanel.add(firstButton);
            settingsPanel.add(secondButton);
            settingsPanel.add(thirdButton);
            settingsPanel.add(fourthButton);
            add(settingsPanel);

        }

    }