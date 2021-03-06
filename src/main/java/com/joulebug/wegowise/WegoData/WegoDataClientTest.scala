package com.joulebug.wegowise.WegoData


/**
 * Created by shraddharathod on 8/7/15.
 */

object WegoDataClientTest {

  def WDCTest() {

    println("Please enter the key:")
    val key = Console.readLine.toString

    println("Please enter the secret:")
    val secret = Console.readLine.toString

    val WDC = new WegoDataClient(key, secret)

    WDC.run()

    val arrayOne: Array[WegoDataMeter] = WDC.getDataOnlyMeter()

    for (parsed <- arrayOne) {
      println("Coverage: " + parsed.getCoverage())
      println("Data-Type: " + parsed.getData_type())
      println("For heating? " + parsed.getFor_heating())
      println(parsed.getId())
      println("Notes: " + parsed.getNotes())
      println("Utility Company ID: " + parsed.getUtility_company.getId())
      println("Utility Company Name: " + parsed.getUtility_company.getName())
      println();
    }
    val meterWithID = WDC.getWegoDataMeterWithID(arrayOne.head.getId)

    println("Coverage: " + meterWithID.getCoverage())
    println("Data-Type: " + meterWithID.getData_type())
    println("For heating? " + meterWithID.getFor_heating())
    println("ID: " + meterWithID.getId())
    println("Notes: " + meterWithID.getNotes())
    println("Utility Company ID: " + meterWithID.getUtility_company.getId())
    println("Utility Company Name: " + meterWithID.getUtility_company.getName())

    try {
      val viewLogin = WDC.getViewLogin(arrayOne.head.getId)

      println("ID: " + viewLogin.getId())
      println("Status: " + viewLogin.getStatus())
      println("Username: " + viewLogin.getUsername())
      println("Utility Company Name: " + viewLogin.getUtility_company().getName())
      println("Account Numbers: " + viewLogin.getAccount_numbers())
    } catch {
      case e: Exception => println("Something went wrong!" + e.toString())
    }
    try {
      val arrayTwo: Array[WegoRawDataPoint] = WDC.getMeterRawData(arrayOne.head.getId)
      for (parsed <- arrayTwo) {

        println("Delivery Charge: " + parsed.getDelivery_charge())
        println("End date: " + parsed.getEnd_date())
        println("Fuel Charge: " + parsed.getFuel_charge())
        println("Total Charge: " + parsed.getTotal_charge())
        println("Start Date: " + parsed.getStart_date())
        println("Gallons: " + parsed.getGallons())
        println("Kwh: " + parsed.getKwh())
        println("Btu: " + parsed.getBtu())
        println("Demand Charge: " + parsed.getDemand_charge())
        println("Demand kw: " + parsed.getDemand_kw())
        println("Fixed Charge: " + parsed.getFixed_charge())
        println("Off Peak Charge: " + parsed.getOff_peak_charge())
        println("Off Peak kwh: " + parsed.getOff_peak_kwh())
        println("Peak Charge: " + parsed.getPeak_charge())
        println("Peak kwh: " + parsed.getPeak_kwh())
      }
    } catch {
      case e: Exception => println("Something went wrong!" + e.toString())

    }

//    try {
//      val wegoRawDataPoint = WDC.getMeterRawDataPoint(151264, 1169829)
//      println("Delivery Charge: " + wegoRawDataPoint.getDelivery_charge())
//      println("End date: " + wegoRawDataPoint.getEnd_date())
//      println("Fuel Charge: " + wegoRawDataPoint.getFuel_charge())
//      println("Total Charge: " + wegoRawDataPoint.getTotal_charge())
//      println("Start Date: " + wegoRawDataPoint.getStart_date())
//      println("Gallons: " + wegoRawDataPoint.getGallons())
//      println("Kwh: " + wegoRawDataPoint.getKwh())
//    } catch {
//      case e: Exception => println("Something went wrong!" + e.toString())
//    }



    try {
      val wegoRawDatum = WDC.getMeterRawDatum(arrayOne.head.getId)

      println("Delivery Charge: " + wegoRawDatum.getDelivery_charge())
      println("End date: " + wegoRawDatum.getEnd_date())
      println("Fuel Charge: " + wegoRawDatum.getFuel_charge())
      println("Total Charge: " + wegoRawDatum.getTotal_charge())
      println("Start Date: " + wegoRawDatum.getStart_date())
      println("Gallons: " + wegoRawDatum.getGallons())
      println("Kwh: " + wegoRawDatum.getKwh())
      println("Btu: " + wegoRawDatum.getBtu())
      println("Demand Charge: " + wegoRawDatum.getDemand_charge())
      println("Demand kw: " + wegoRawDatum.getDemand_kw())
      println("Fixed Charge: " + wegoRawDatum.getFixed_charge())
      println("Off Peak Charge: " + wegoRawDatum.getOff_peak_charge())
      println("Off Peak kwh: " + wegoRawDatum.getOff_peak_kwh())
      println("Peak Charge: " + wegoRawDatum.getPeak_charge())
      println("Peak kwh: " + wegoRawDatum.getPeak_kwh())
    } catch {
      case e: Exception => println("Something went wrong!" + e.toString())
    }
  }
}
