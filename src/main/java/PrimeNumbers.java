import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 22.01.2016.
 */
public class PrimeNumbers {
    JPanel mainPanel;
    JButton findAllPrimes;
    JSpinner fromValue;
    JSpinner toValue;
    JList<String> primesList;
    JScrollPane result;

    public PrimeNumbers() { //Конструктор
        fromValue.setValue(1000);// Задаем начальное значение
        toValue.setValue(5000);//Задаем конечное значение
         //primesList.setv("");


        findAllPrimes.addActionListener(e -> new Thread(() -> {
            //Поиск простых чисел выделяем в отдельный поток
            SwingUtilities.invokeLater(new Runnable() { //Конструкция позволяет выполнять действия между событиями
                @Override
                public void run() {
                    int currentNumber, dividers;

                    for (currentNumber = 1; currentNumber < 50; currentNumber++)
                    {
                        dividers = 0;
                        for (int i = 1; i <= currentNumber; i++)
                        {
                            if (currentNumber % i == 0)
                                dividers++;
                        }
                        if (dividers <= 2);

                           // primesList.getSelectedValuesList(currentNumber);
                            //System.out.println(currentNumber);
                    }
                }
            });

        }).start());
    }

    public static void main(String[] args){
        //Создаем форму
        JFrame frame = new JFrame ("Поиск простых чисел");
        //класс соответствующий форме
        PrimeNumbers primeNumbers = new PrimeNumbers();
        // Задаём содержимое формы
        frame.setContentPane(new PrimeNumbers().mainPanel);
        // Выравниваем компоненты
        frame.pack();
        // При закрытии окна закрываем и программу,
        // иначе она останется висеть в процессах
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Показываем форму
        frame.setVisible(true);
    }
};



