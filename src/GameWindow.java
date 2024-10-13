
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameWindow extends JFrame {
    private JButton drawButton;
    private JLabel drawnNumberLabel;
    private JTextArea playerStatus;
    private ArrayList<Player> players;
    private int currentDrawnNumber;
    private GameLogic gameLogic;

    public GameWindow() {
        setTitle("Bingo Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        players = new ArrayList<>();
        gameLogic = new GameLogic();

        // Adăugăm câțiva jucători
        players.add(new Player("Player 1", gameLogic.createBingoCard()));
        players.add(new Player("Player 2", gameLogic.createBingoCard()));

        // Crearea componentelor UI
        drawButton = new JButton("Draw Number");
        drawnNumberLabel = new JLabel("Drawn Number: ");
        playerStatus = new JTextArea();
        playerStatus.setEditable(false);

        drawButton.addActionListener(new DrawButtonListener());

        // Layout
        JPanel panel = new JPanel();
        panel.add(drawButton);
        add(panel, BorderLayout.SOUTH);
        add(drawnNumberLabel, BorderLayout.NORTH);
        add(new JScrollPane(playerStatus), BorderLayout.CENTER);

        updatePlayerStatus();
    }

    private void updatePlayerStatus() {
        StringBuilder status = new StringBuilder();
        for (Player player : players) {
            status.append(player.getName()).append(": ").append(player.getBingoCard()).append("\n");
        }
        playerStatus.setText(status.toString());
    }

    private class DrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentDrawnNumber = gameLogic.drawNumber();
            drawnNumberLabel.setText("Drawn Number: " + currentDrawnNumber);
            checkWinners();
        }
    }

    private void checkWinners() {
        for (Player player : players) {
            if (player.getBingoCard().checkNumber(currentDrawnNumber)) {
                JOptionPane.showMessageDialog(this, player.getName() + " has a Bingo!");
            }
        }
    }
}
