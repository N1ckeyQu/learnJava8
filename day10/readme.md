# day10学习总结

## 构造器的作用是什么

- 用于创建对象，每个类都默认自带一个无参构造方法
- 有参构造器可以在创建对象时，给对象的属性赋值

## 构造器使用过程中的注意点

- 不一定每个类都需要创建构造器，默认自带一个无参构造方法
- 创建类的有参构造之后，再次调用无参构造方法编译不通过，此时需要手动写一个无参构造
- 如果我们想在对象创建时加一些自定义逻辑，我们可以把逻辑写在构造器中，然后用户调用构造器创建对象时是无感知的，这也体现了封装性
- 构造器与构造器之间可以通过this关键字相互调用，因此如果一段自定义逻辑需要在多个构造器中实现，除了将自定义逻辑抽取成方法之外，还可以通过构造器之间相互调用来实现。注意，形参列表多的构造器调用形参列表少的构造器

## 类的属性有哪些赋值方式以及它们的先后顺序

- 显式赋值

  private int i = 1;

- 默认赋值

  private int i;

- 有参构造器赋值

  public Boy(String name, int age) {

  ​	this.name = name;

  ​	this.age = age;

  }

- 直接给对象的属性赋值

  set方法/对象.属性

> 先后顺序：2 > 1 > 3 > 4

## this关键字可以用来调用哪些结构

this关键字可以调用属性、方法、构造器

- 属性

  其实经常见到，比如set方法中，为了区分两个相同名字的变量，this.变量名就表示该变量是当前类中的变量

- 方法

  比如我们在某个类中写了很多方法，方法和方法之间可以直接通过方法名()相互调用，其实真正的写法应该是this.方法名()。使用javap或者IDEA直接打开字节码文件，你就会发现其实真正运行的代码的写法是this.方法名()

- 构造器

  this用于调用构造器的情况，常见于多个构造器需要实现同一段自定义逻辑。很多人都会想到将这段自定义逻辑抽取成一个方法，来提高代码的复用程度。其实还有一种方法是：通过this来调用构造器，我们将自定义逻辑写在某一个构造方法A中，假如此时构造器B和C也需要实现这段自定义逻辑，可以在构造器B和C中使用this来调用构造方法A，执行自定义逻辑，提高代码复用性

  注意：构造B调用构造器A，执行了两个构造器方法，并不会创造两个构造器对象，执行构造器调用链路之后，只会生成一个对象

## 目前学习到的四个权限修饰符

|                | public | protected | 缺省 | private |
| :------------: | :----: | :-------: | :--: | :-----: |
|    同一工程    |   ✅    |           |      |         |
| 不同包下的子类 |   ✅    |     ✅     |      |         |
|    同一个包    |   ✅    |     ✅     |  ✅   |         |
|    同一个类    |   ✅    |     ✅     |  ✅   |    ✅    |

