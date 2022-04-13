package ch19.status_machine;

import static ch19.status_machine.Status.*;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

//饮料机的输入
enum Input {
    IN_COIN, OUT_COIN, TURN_BUTTON, IN_DRINK;
}

//饮料机状态
enum Status {
    READY_COIN {
        @Override
        public Status next(Input input, DrinkMachine dm) {
            if (input == Input.IN_COIN) {
                dm.setCoins(dm.getCoins() + 1);
                return AREADY_COIN;
            }
            System.out.println("no support this operation.");
            return this;
        }
    },
    AREADY_COIN {
        @Override
        public Status next(Input input, DrinkMachine dm) {
            if (input == Input.OUT_COIN) {
                dm.setCoins(dm.getCoins() - 1);
                return READY_COIN;
            } else if (input == Input.TURN_BUTTON) {
                return OUT_DRINK;
            }
            System.out.println("no support this operation.");
            return this;
        }
    },
    OUT_DRINK {
        @Override
        public Status next(DrinkMachine dm) {
            dm.setDrinks(dm.getDrinks() - 1);
            if (dm.getDrinks() <= 0) {
                return NO_DRINK;
            } else {
                return READY_COIN;
            }
        }
    },
    NO_DRINK {
        @Override
        public Status next(Input input, DrinkMachine dm) {
            if (input == Input.IN_DRINK) {
                dm.setDrinks(20);
                return READY_COIN;
            }
            System.out.println("no support this operation.");
            return this;
        }
    };

    //判断是否瞬时状态
    public boolean isTrasientStatus() {
        if (StatusCategory.getCategory(this) == StatusCategory.TRASIENT) {
            return true;
        }
        return false;
    }

    //一般状态的状态流转（需要输入）
    public Status next(Input input, DrinkMachine dm) {
        if (this.isTrasientStatus()) {
            throw new RuntimeException("only used for normal status.");
        }
        return null;
    }

    //瞬时状态的状态流转（不需要输入）
    public Status next(DrinkMachine dm) {
        if (!this.isTrasientStatus()) {
            throw new RuntimeException("only used for trasient status.");
        }
        return null;
    }
}

//状态分类
enum StatusCategory {
    //一般状态
    NOMAL(READY_COIN, AREADY_COIN, NO_DRINK),
    //瞬时状态
    TRASIENT(OUT_DRINK);

    private Status[] statuses;

    private StatusCategory(Status... statuses) {
        this.statuses = statuses;
    }

    public static StatusCategory getCategory(Status status) {
        for (StatusCategory sc : StatusCategory.values()) {
            for (Status s : sc.statuses) {
                if (s == status) {
                    return sc;
                }
            }
        }
        return null;
    }
}

class DrinkMachine {
    private int drinks = 0;
    private int coins = 0;
    private Status status = NO_DRINK;

    public DrinkMachine() {
        this.operate(Input.IN_DRINK);
    }

    public void operate(Input input) {
        Status newStatus = this.status.next(input, this);
        this.status = newStatus;
        System.out.println(this);
        // 如果新状态是一个瞬时状态，继续运行，直到一个非瞬时状态
        while (newStatus.isTrasientStatus()) {
            newStatus = newStatus.next(this);
            this.status = newStatus;
            System.out.println(this);
        }
    }

    public int getDrinks() {
        return drinks;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("now drink machine: drinks(%d), coins(%d), status(%s).", this.drinks, this.coins,
                this.status);
    }
}

class RandomInput implements Generator<Input> {
    private static Random rand = new Random();

    @Override
    public Input next() {
        Input[] inputs = Input.values();
        return inputs[rand.nextInt(inputs.length)];
    }

}

public class Main {
    public static void main(String[] args) {
        DrinkMachine dm = new DrinkMachine();
        RandomInput ri = new RandomInput();
        for (int i = 0; i < 20; i++) {
            Input input = ri.next();
            Fmt.printf("now do operate %s\n", input);
            dm.operate(input);
        }
    }
}
// now drink machine: drinks(20), coins(0), status(READY_COIN).
// now do operate IN_COIN
// now drink machine: drinks(20), coins(1), status(AREADY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(20), coins(1), status(AREADY_COIN).
// now do operate IN_COIN
// no support this operation.
// now drink machine: drinks(20), coins(1), status(AREADY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(20), coins(1), status(AREADY_COIN).
// now do operate IN_COIN
// no support this operation.
// now drink machine: drinks(20), coins(1), status(AREADY_COIN).
// now do operate TURN_BUTTON
// now drink machine: drinks(20), coins(1), status(OUT_DRINK).
// now drink machine: drinks(19), coins(1), status(READY_COIN).
// now do operate OUT_COIN
// no support this operation.
// now drink machine: drinks(19), coins(1), status(READY_COIN).
// now do operate TURN_BUTTON
// no support this operation.
// now drink machine: drinks(19), coins(1), status(READY_COIN).
// now do operate IN_COIN
// now drink machine: drinks(19), coins(2), status(AREADY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(19), coins(2), status(AREADY_COIN).
// now do operate TURN_BUTTON
// now drink machine: drinks(19), coins(2), status(OUT_DRINK).
// now drink machine: drinks(18), coins(2), status(READY_COIN).
// now do operate TURN_BUTTON
// no support this operation.
// now drink machine: drinks(18), coins(2), status(READY_COIN).
// now do operate IN_COIN
// now drink machine: drinks(18), coins(3), status(AREADY_COIN).
// now do operate OUT_COIN
// now drink machine: drinks(18), coins(2), status(READY_COIN).
// now do operate IN_COIN
// now drink machine: drinks(18), coins(3), status(AREADY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(18), coins(3), status(AREADY_COIN).
// now do operate TURN_BUTTON
// now drink machine: drinks(18), coins(3), status(OUT_DRINK).
// now drink machine: drinks(17), coins(3), status(READY_COIN).
// now do operate OUT_COIN
// no support this operation.
// now drink machine: drinks(17), coins(3), status(READY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(17), coins(3), status(READY_COIN).
// now do operate IN_DRINK
// no support this operation.
// now drink machine: drinks(17), coins(3), status(READY_COIN).