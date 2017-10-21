    package Assignment6;

    import static org.junit.Assert.*;

    import Assignment6.Atm;
    import Assignment6.User;
    import org.junit.*;

    /**
    * Atm Tester.
    *
    * @author <Authors name>
    * @since <pre>十月 21, 2017</pre>
    * @version 1.0
    */
    public class

    AtmTest {
        Atm atm = new Atm(60000,2.0);
        User cieraW = new User("Ciera",22,"John St.","1234567890","0001");
        User markW = new User("Mark", 19, "Dexter St.", "0123456789","0002");
        UserData udCieraW = new UserData(cieraW, "0001");
        UserData udMarkW = new UserData(markW, "0002");
        //User current = cieraW;

    @Before
    public void before() throws Exception {
        //System.out.println("BeforeClass");
        atm.userList.add(udCieraW);
        atm.userList.add(udMarkW);

    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: main(String[] args)
    *
    */
    @Test
    public void testMain() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: login()
    *
    */
    @Ignore
    @Test
    public void testLogin() throws Exception {
    //TODO: Test goes here...
        System.out.println("Ignore");
    }

    /**
    *
    * Method: check(String bankAccountNumber, String password)
    *
    */
    @Test
    public void testCheck() throws Exception {
    //TODO: Test goes here...
        System.out.println("Check");
        assertEquals(true, atm.check("0001", "0001"));
        assertEquals(false, atm.check("0001", "0002"));
        assertEquals(false, atm.check("0002", "0001"));

    }

    /**
    *
    * Method: validate(String name, int age, String phone)
    *
    */
    @Test
    public void testValidate() throws Exception {
    //TODO: Test goes here...
        //global
        atm.current = udCieraW;
        assertEquals(true, atm.validate("Ciera", 22, "1234567890"));
        assertEquals(false, atm.validate("Ciera", 23, "1234567890"));
        atm.current = udMarkW;
        assertEquals(true, atm.validate("Mark", 19, "0123456789"));
        assertEquals(false, atm.validate("Markq", 19, "0123456789"));

    }

    /**
    *
    * Method: operate()
    *
    */
    @Test
    public void testOperate() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: availableBalance()
    *
    */
    @Test
    public void testAvailableBalance() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        assertEquals(0.0, atm.availableBalance(),0.009);
        atm.deposit(10);
        assertEquals(8.0, atm.availableBalance(),0.009);
        atm.withDrawal(4);
        assertEquals(2.0, atm.availableBalance(),0.009);
    }

    /**
    *
    * Method: withDrawal(double money)
    *
    */
    @Test
    public void testWithDrawal() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        assertEquals(false, atm.withDrawal(10));
        atm.deposit(100);
        assertEquals(true, atm.withDrawal(6));

    }

    /**
    *
    * Method: deposit(double money)
    *
    */
    @Test
    public void testDeposit() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        atm.deposit(20);
        assertEquals(18.0, atm.availableBalance(),0.009);
        atm.deposit(30);
        assertEquals(46.0, atm.availableBalance(),0.009);
    }

    /**
    *
    * Method: recentTransactions()
    *
    */
    @Test
    public void testRecentTransactions() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        assertEquals(0, atm.recentTransactions());
        atm.deposit(20);
        atm.deposit(20);
        atm.deposit(20);
        atm.deposit(20);
        atm.deposit(20);
        atm.withDrawal(4);
        atm.withDrawal(4);
        atm.deposit(20);
        atm.deposit(20);
        assertEquals(9, atm.recentTransactions());
        atm.withDrawal(4);
        atm.withDrawal(4);
        atm.withDrawal(4);
        assertEquals(10, atm.recentTransactions());
    }

    /**
    *
    * Method: forgotPassword(String bankAccountNumber)
    *
    */
    @Test
    public void testForgotPassword() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: resetPassword(String name, int age, String phone, String newPassword)
    *
    */
    @Test
    public void testResetPassword() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        assertEquals(true, atm.resetPassword("Ciera", 22, "1234567890", "1235"));
        assertEquals(false, atm.resetPassword("Ciera", 22, "14567890", "1235"));

    }

    /**
    *
    * Method: register()
    *
    */
    @Test
    public void testRegister() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: start()
    *
    */
    @Test
    public void testStart() throws Exception {
    //TODO: Test goes here...
    }


    /**
    *
    * Method: print(String str, double money)
    *
    */
    @Test
    public void testPrint() throws Exception {
    //TODO: Test goes here...
    /*
    try {
       Method method = Atm.getClass().getMethod("print", String.class, double.class);
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
    }

    /**
    *
    * Method: changePassword(String newPassword)
    *
    */
    @Test
    public void testChangePassword() throws Exception {
    //TODO: Test goes here...
        atm.current = udCieraW;
        assertEquals(true, atm.changePassword("1234"));
    }

    /**
    *
    * Method: exit()
    *
    */
    @Test
    public void testExit() throws Exception {
    //TODO: Test goes here...
    /*
    try {
       Method method = Atm.getClass().getMethod("exit");
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
    }

    }
