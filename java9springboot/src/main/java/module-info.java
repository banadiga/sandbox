module java9springboot {
  requires sandboxjava9module;
  requires spring.boot.autoconfigure;
  requires spring.context;
  requires spring.web;
  requires spring.boot;
  exports com.banadiga.java9springboot;
}
