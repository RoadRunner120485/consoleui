package de.codeshelf.consoleui.prompt;

import de.codeshelf.consoleui.elements.Checkbox;
import de.codeshelf.consoleui.elements.items.CheckboxItemIF;
import de.codeshelf.consoleui.elements.items.impl.CheckboxItem;
import de.codeshelf.consoleui.elements.items.impl.Separator;
import de.codeshelf.consoleui.prompt.reader.Reader;
import org.jline.reader.Completer;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: Andreas Wegmann
 * Date: 07.12.15
 */
public class CheckboxPromptTest {
  @Test
  public void renderSimpleList() throws IOException {
    CheckboxPrompt checkboxPrompt = new CheckboxPrompt();
    List<CheckboxItemIF> list=new ArrayList<CheckboxItemIF>();

    list.add(new CheckboxItem("One"));
    list.add(new CheckboxItem(true,"Two"));
    CheckboxItem three = new CheckboxItem("Three");
    three.setDisabled("not available");
    list.add(three);
    list.add(new Separator("some extra items"));
    list.add(new CheckboxItem("Four"));
    list.add(new CheckboxItem(true,"Five"));

    checkboxPrompt.setReader(new Reader() {
      public void setAllowedSpecialKeys(Set<SpecialKey> allowedSpecialKeys) {

      }

      public void setAllowedPrintableKeys(Set<Character> allowedPrintableKeys) {

      }

      public void addAllowedPrintableKey(Character character) {

      }

      public void addAllowedSpecialKey(SpecialKey specialKey) {

      }

      public ReaderInput read() {
        return new ReaderInput(SpecialKey.ENTER);
      }

      public ReaderInput readLine(List<Completer> completer, String promt, String value, Character mask) throws IOException {
        return null;
      }
    });

    checkboxPrompt.prompt(new Checkbox("no message", null, list));
  }

}