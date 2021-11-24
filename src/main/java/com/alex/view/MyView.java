package com.alex.view;

import com.alex.controller.*;
import com.alex.controller.interfaces.GeneralController;
import com.alex.model.models.*;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.*;

public class MyView implements Printable {
  private final Map<String, GeneralController> controller;
  private final Map<String, GeneralModel> models;
  private String consoleInput;
  private Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
  boolean isQuit;

  public MyView() {
    isQuit = false;
    models = new HashMap<>();
    controller = new HashMap<>();

    controller.put("AgencyAnimator", new AgencyAnimatorControllerImpl());
    controller.put("Agency", new AgencyControllerImpl());
    controller.put("AgencyType", new AgencyTypeControllerImpl());
    controller.put("Animator", new AnimatorControllerImpl());
    controller.put("Client", new ClientControllerImpl());
    controller.put("EventAddress", new EventAddressControllerImpl());
    controller.put("Event", new EventControllerImpl());
    controller.put("OrderClient", new OrderClientControllerImpl());
    controller.put("Price", new PriceControllerImpl());
    models.put("AgencyAnimator", new AgencyAnimator());
    models.put("Agency", new Agency());
    models.put("AgencyType", new AgencyType());
    models.put("Animator", new Animator());
    models.put("Client", new Client());
    models.put("EventAddress", new EventAddress());
    models.put("Event", new Event());
    models.put("OrderClient", new OrderClient());
    models.put("Price", new Price());

  }

  @Override
  public void print() {
    while (!isQuit) {
      try {
        System.out.println("<-- Menu -->");
        System.out.println(getTables());
        consoleInput = input.nextLine().toUpperCase();
        switch (consoleInput) {
          case "AA" -> printMethod("AgencyAnimator");
          case "AG" -> printMethod("Agency");
          case "AT" -> printMethod("AgencyType");
          case "AN" -> printMethod("Animator");
          case "C" -> printMethod("Client");
          case "EA" -> printMethod("EventAddress");
          case "E" -> printMethod("Event");
          case "OC" -> printMethod("OrderClient");
          case "P" -> printMethod("Price");
        }
      } catch (Exception a) {
        System.out.println("invalid input");
      }
    }
  }

  private void printMethod(String table) throws SQLException {
    boolean isBack = false;
    while (!isBack) {
      System.out.println(getMethodModel(table));
      consoleInput = input.nextLine().toUpperCase();
      switch (consoleInput) {
        case "FA" -> findAll(controller.get(table));
        case "FBI" -> findById(controller.get(table));
        case "C" -> create(controller.get(table), models.get(table));
        case "U" -> update(controller.get(table), models.get(table));
        case "D" -> delete(controller.get(table));
        case "B" -> isBack = true;
        default -> System.out.println("invalid input");
      }
    }
  }

  private String getTables() {
    StringBuffer str = new StringBuffer();
    str.append("  AA - AgencyAnimator\n");
    str.append("  AG - Agency\n");
    str.append("  AT - AgencyType\n");
    str.append("  AN - Animator\n");
    str.append("  C - Client\n");
    str.append("  EA - EventAddress\n");
    str.append("  E - Event\n");
    str.append("  OC - OrderClient\n");
    str.append("  P - Price\n");
    return str.toString();
  }


  private String getMethodModel(String table) {
    StringBuffer str = new StringBuffer();
    str.append(table + "\n");
    str.append("    FA - Find All\n");
    str.append("    FBI - Find by id\n");
    str.append("    C - Create\n");
    str.append("    U - Update\n");
    str.append("    D - Delete\n");
    str.append("    B - back\n");
    return str.toString();
  }

  private GeneralModel getModel(GeneralModel model, boolean isToUpdate) {
    try {
      model = model.getClass().getConstructor().newInstance();
      Field[] fields = model.getClass().getDeclaredFields();
      for (Field field : fields) {
        if (field.getName() == "id" && !isToUpdate) {
          continue;
        }
        System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
        consoleInput = input.nextLine();
        field.setAccessible(true);
        switch (field.getAnnotatedType().toString()) {
          case "java.lang.Integer":
            field.set(model, Integer.parseInt(consoleInput));
            break;
          case "java.lang.String":
            field.set(model, consoleInput);
            break;
          case "java.lang.Float":
            field.set(model, Float.parseFloat(consoleInput));
            break;
          case "java.lang.Double":
            field.set(model, Double.parseDouble(consoleInput));
            break;
          default:
            break;

        }
      }
      return model;
    } catch (Exception a) {
      System.out.println("bad input" + a);
    }
    return null;
  }

  private void findAll(GeneralController controller) throws SQLException {
    for (Object a:controller.findAll()){
      System.out.println(a);
    }
  }

  private void findById(GeneralController controller) throws  SQLException{
    System.out.println("Print model id:");
    consoleInput = input.nextLine();
    System.out.println(controller.findById(Integer.parseInt(consoleInput)));
  }

  private void create(GeneralController controller, GeneralModel model) throws SQLException{
    controller.create(getModel(model,false));
    System.out.println("Done!");
  }

  private void update(GeneralController controller,GeneralModel model) throws SQLException {
    model = getModel(model, true);
    if (model == null) {
      System.out.println("Bad Input");
    } else {
        controller.update(model);
        System.out.println("Done!");
    }
  }

  public void delete(GeneralController controller) throws SQLException{
    System.out.println("Print id to delete element:");
    consoleInput = input.nextLine();
    System.out.println("Done!");
    System.out.println(controller.delete(Integer.parseInt(consoleInput)));
  }
}


