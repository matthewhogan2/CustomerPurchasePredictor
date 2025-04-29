package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PredictorGUI extends JFrame {
	
	
	private JComboBox<String> labelBox;
    private JComboBox<String> ageBox;
    private JComboBox<String> incomeBox;
    private JComboBox<String>prevBox;
    private JComboBox<String> promoBox;
    private JButton predictBtn;
    private JLabel resultLabel;
    private JButton customer_add;

    
    public PredictorGUI(Dataset dataset) {
    	
        // Train classifier once
        NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataset);
        classifier.train();

        //window config
        setTitle("Customer Purchase Predictor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(8, 2, 5, 5));
        setSize(500,700);

        ageBox= new JComboBox<>(new String[]{"young", "old"});
        incomeBox= new JComboBox<>(new String[]{"high", "low"});
        prevBox= new JComboBox<>(new String[]{"no", "yes"});
        promoBox= new JComboBox<>(new String[]{"yes", "no"});
        labelBox = new JComboBox<>(new String[]{"yes", "no"});

        add(new JLabel("Age Group:"));        
        add(ageBox);
        add(new JLabel("Income Level:"));     
        add(incomeBox);
        add(new JLabel("Previous Purchases:")); 
        add(prevBox);
        add(new JLabel("Promo Interest:"));   
        add(promoBox);
        add(new JLabel("Made Purchase:"));   
        add(labelBox);
        

        predictBtn= new JButton("Predict");
        resultLabel = new JLabel("Prediction: ");
        customer_add= new JButton("Add Customer");
        
        add(customer_add);
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
                    ""//label not used
                );
                
                String pred = classifier.predict(input);
                resultLabel.setText("Prediction: " + pred);
                
            }
               
        });
     
        setVisible(true);
        
        //level 3 GUI user add new customer and retrains the model
        customer_add.addActionListener(new ActionListener(){
        	@Override
        	
        	public void actionPerformed(ActionEvent e) {
        		String age=(String)ageBox.getSelectedItem();
                String income=(String)incomeBox.getSelectedItem();
                String prev=(String) prevBox.getSelectedItem();
                String promo=(String)promoBox.getSelectedItem();
                String madePurchase=(String)labelBox.getSelectedItem();

                Customer newCustomer = new Customer(age, income, prev, promo, madePurchase);
                dataset.addCustomer(newCustomer);
                classifier.train();	
        	}
        	
        	
        	
        
        });
        
    }
}
