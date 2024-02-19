package rvt.exercises;

public class Money {
    private final int euros;
    private final int cents;

    // Construcor
    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }
    // Constructor overloading // Second class constructor
    public Money() {
        this.euros = 0;
        this.cents = 0;
    }
    // Constructor overloading // Third constructor
    public Money(int euros) {
        this.euros = euros;
        this.cents = 0;
    }


    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public Money plus(Money addition) {
        int newEuros = this.euros + addition.euros;
        int newCents = this.cents + addition.cents;
        
        if (newCents >= 100) {
            newCents -= 100;
            newEuros++;
        }
        return new Money(newEuros, newCents); // create a new Money object that has the correct worth
    }

    // Method overloading
    public Money plus(int euroAmount) {
        // 10 + 5
        int newEuros = this.euros + euroAmount;
        // 90 + 90
        return new Money(newEuros, 0); // create a new Money object that has the correct worth
    }

    public Money minus(Money decreaser) {
        if (this.euros - decreaser.euros <= 0 
        && this.cents - decreaser.cents <= 0)
        {
            return new Money(0, 0);
        }
        int newEuros = this.euros - decreaser.euros;
        int newCents = this.cents - decreaser.cents;

        if (newCents < 0) {
            newEuros--;
            newCents = 100 + newCents;
        }
        return new Money(newEuros, newCents);
    }

    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.cents < compared.cents && this.euros <= compared.euros) {
            return true;
        }
        return false;
    }

    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + " EUR";
    }
    
    public boolean equals(Object compared) {
        // if the variables are located in the same position, they are equal
        
        if (this == compared) {
            return true;
        }

        // if the compared object is not of type Person, the objects are not equal
        if (!(compared instanceof Money)) {
            return false;
        }

        // convert the object into a Money object
        Money comparedMoney = (Money) compared;

        // if the values of the object variables are equal, the objects are equal
        if (this.euros == comparedMoney.euros
            && this.cents == comparedMoney.cents
        ) {
            return true;
        }
        // otherwise the objects are not equal
        return false;
    }
}
