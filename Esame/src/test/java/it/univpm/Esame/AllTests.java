package it.univpm.Esame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * classe che permette di effettuare tutti i test contemporaneamente
 * @author Christian
 *
 */

@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
@SelectClasses({BodyClassTest.class,LavoroTest.class,StatisticsTest.class,FiltersTest.class, StatisticsTest.class})
class AllTests {

}
