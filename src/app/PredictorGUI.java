package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PredictorGUI extends JFrame {
	
    private JComboBox<String> ageBox;
    private JComboBox<String> incomeBox;
    private JComboBox<String> prevBox;
    private JComboBox<String> promoBox;
    private JButton predictBtn;
    private JLabel resultLabel;

    
    public PredictorGUI(Dataset dataset) {
    	
        // Train classifier once
        NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataset);
        classifier.train();

        //window config
        setTitle("Customer Purchase Predictor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));
        setSize(400, 250);

        ageBox = new JComboBox<>(new String[]{"young", "old"});
        incomeBox = new JComboBox<>(new String[]{"high", "low"});
        prevBox = new JComboBox<>(new String[]{"no", "yes"});
        promoBox = new JComboBox<>(new String[]{"yes", "no"});

        add(new JLabel("Age Group:"));        add(ageBox);
        add(new JLabel("Income Level:"));     add(incomeBox);
        add(new JLabel("Previous Purchases:")); add(prevBox);
        add(new JLabel("Promo Interest:"));   add(promoBox);

        predictBtn = new JButton("Predict");
        resultLabel = new JLabel("Prediction: ");

        add(predictBtn);
        add(resultLabel);

        predictBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Customer input = new Customer(
                		
                    (String) ageBox.getSelectedItem(),
                    (String) incomeBox.getSelectedItem(),
                    (String) prevBox.getSelectedItem(),
                    (String) promoBox.getSelectedItem(),
                    ""  // label not used here
                );
                
                String pred = classifier.predict(input);
                resultLabel.setText("Prediction: " + pred);
                
            }
            
        });

        setVisible(true);
    }
}
