// Source code is decompiled from a .class file using FernFlower decompiler.
package Fsm;

public abstract class State {
   private String stateName;

   public State(String name) {
      this.stateName = name;
   }

   public String getName() {
      return this.stateName;
   }

   public String toString() {
      return new String("State(" + this.stateName + ")");
   }
}
