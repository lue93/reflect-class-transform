package br.com.lue93.lib.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformer {

    public <I, O> O transform(I inputObj, Class out) throws ClassCastException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

            Class<?> clazzIn = inputObj.getClass();
            Class<?> clazzOut = Class.forName(out.getName());// + "DTO");

            O outputObj = (O) clazzOut.getDeclaredConstructor().newInstance();

            Field[] inFields = clazzIn.getDeclaredFields();
            Field[] outFields = clazzOut.getDeclaredFields();

            // transport data between objects
            Arrays.stream(inFields)
                    .forEach(inField -> {
                        Arrays.stream(outFields)
                                .forEach(outField -> {
                                    if (inField.getName().equals(outField.getName())
                                            && inField.getType().equals(outField.getType())) {
                                        inField.setAccessible(true);
                                        outField.setAccessible(true);
                                        try {
                                            outField.set(outputObj, inField.get(inputObj));
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                    });
        return outputObj;
    }
}