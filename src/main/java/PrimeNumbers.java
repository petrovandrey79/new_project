import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 22.01.2016.
 * Мой вариант программы
 */
public class PrimeNumbers {
    JPanel mainPanel;
    JButton findAllPrimes;
    JSpinner fromValue;
    JSpinner toValue;
    JList<String> primesList;
    JScrollPane result;

    public PrimeNumbers() { //Конструктор
        fromValue.setValue(100000);// Задаем начальное значение
        toValue.setValue(1500000);//Задаем конечное значение
         //primesList.setv("");
        DefaultListModel<String> primes = new DefaultListModel<>();
        primesList.setModel(primes);


        findAllPrimes.addActionListener(e -> new Thread(() -> {
            //Поиск простых чисел выделяем в отдельный поток
            SwingUtilities.invokeLater(() -> {
                int from = (int) fromValue.getValue();
                int to = (int) toValue.getValue();
                System.out.println("Поиск простых чисел в диапазоне " + from + "..." + to);

                int currentNumber, dividers;

                for (currentNumber = from; currentNumber < to; currentNumber++)
                {
                    dividers = 0;
                    for (int i = 1; i <= currentNumber; i++)
                    {
                        if (currentNumber % i == 0)
                            dividers++;
                    }
                    if (dividers <= 2) {
                        //System.out.println(currentNumber);
                        final int prime = currentNumber;
                        SwingUtilities.invokeLater(() -> {
                            // Действия между событиями Swing
                            primes.addElement(Integer.toString(prime));
                        });
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



