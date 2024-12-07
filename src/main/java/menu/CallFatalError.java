package menu;

import Company.MobileCompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CallFatalError implements MenuItem {
    private static final Logger logger = LogManager.getLogger(CallFatalError.class);

    Scanner scan;
    MobileCompany company;
    public CallFatalError(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }
    @Override
    public void execute() {
        logger.fatal("Oh no, fatal error occurred. I think it's best time to detonate the nuke!");
        System.exit(-404);
    }

    @Override
    public String getName() {
        return "Викликати Фатальну помилку";
    }
}
