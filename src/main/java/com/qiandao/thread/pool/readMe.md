execute和submit的区别
execute只能提交Runnable类型的任务，无返回值。
submit既可以提交Runnable类型的任务，
也可以提交Callable类型的任务，
会有一个类型为Future的返回值，
但当任务类型为Runnable时，返回值为null。

execute在执行任务时，如果遇到异常会直接抛出，而submit不会直接抛出，
只有在使用Future的get方法获取返回值时，才会抛出异常。

<href>https://www.cnblogs.com/jxxblogs/p/11882381.html</href>