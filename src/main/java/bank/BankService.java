package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, изначательно у пользователя 0 счетов
     */
    public boolean addUser() {
        return false;
    }

    /**
     * Метод добавляет счет пользователю
     */
    public boolean addAccount() {
        return false;
    }

    /**
     * Метод добавляет деньги на счет пользователя
     */
    public boolean addBalanceToAccount(String passport, String requisite, double balance) {
        return false;
    }

    /**
     * Метод должен снять деньги с аккаунта пользователя
     */
    public boolean withDrawBalanceFromAccount(String passport, String requisite, double balance) {
        return false;
    }

    /**
     * Перевести деньги с счета на счет
     */
    public boolean transferMoney(String passportFrom, String requisiteFrom,
                                 String passportTo, String requisiteTo, double balance) {
        return false;
    }



    /**
     * Метод удаляет счет пользователя, если на счету лежат деньги, то их нужно перевести на рандомный
     * любой другой счет пользователя, если же такого счета не существует, то отменить операцию.
     * @param passport паспорт пользователя
     * @param requisite реквизиты пользователя
     */
    public boolean deleteAccountByRequisite(String passport, String requisite) {
        return false;
    }

    /**
     * Метод ищет счет по его реквизитам
     * @param passport паспорт
     * @param requisite реквизиты
     * @return счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    /**
     * Возвращает пользователя по его паспорту
     * @param passport паспорт пользователя
     * @return пользователь
     */
    public User findByPassport(String passport) {
        return null;
    }
}
