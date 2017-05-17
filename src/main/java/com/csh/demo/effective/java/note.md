一、集合
1.1、List
     ArrayList：基于数组。随机访问速度快，插入和移除元素较慢。数组默认大小10，超过扩展 size/2。
     LinkedList     基于双向链表。插入和移除速度较快，优化了顺序访问，随机访问速度较慢。
     Vector：同ArrayList实现基本一致，但Vector是线程安全的，在对外方法上使用了synchronized。
     CopyOnwriteArrayList：线程安全，用于并发编程。是 ArrayList 的一个线程安全的变体，其中所有可变操作（add、set等等）都是通过对底层数组进行一次新的复制来实现的。

1.2、Stack
     栈，后进先出。继承 Vector ，线程安全。主要操作push(压栈)、pop(出栈)、peek(查看栈顶对象)

1.3、Set
     去重，通过 equals() 确保对象的唯一性。
     HashSet：通过散列表实现，存储对象需重写 hashCode()，适合快速查找。代码通过 HashMap<Value，new Object()> 实现.
     TreeSet：有序集合，通过红黑树实现，使用 Comparable() 函数进行比较，默认为升序
     LinkedHashSet：通过散列表存储数据，并使用链表保存插入顺序，存储对象需重写 hashCode()，适合快速查找。
     SortedSet：按对象的比较函数对对象进行排序。由自身Comparator comparator() 排序，默认为自然方式排序。
     NavigableSet：和SortedSet类似。但增加了导航方法

1.4、Map
     <key, value> 集合。key 在集合中唯一，通过 equals() 方法比较。
     HashMap：基于散列表的实现。插入和查询的键值对的开销是固定的。当 尺寸/容量 = 0.75 ，再散列，这个比例可调整。
     HashTable：实现方法和 HashMap 一致，但通过 synchronized 加锁公共方法实现线程安全。
     ConcurrentHashMap：线程安全集合。包含两个静态内部类 HashEntry 和 Segment。默认分为 16 个 Segment 对象。HashEntry 用来封装映射表的键 / 值对；Segment 用来充当锁的角色，每个 Segment 对象守护整个散列映射表的若干个桶。每个桶是由若干个 HashEntry 对象链接起来的链表。Segment 类继承于 ReentrantLock 类，从而使得 Segment 对象能充当锁的角色。
     LinkedHashMap：类似HashMap，但在迭代遍历时，取“键值对”的顺序是其插入顺序。使用链表维护内部次序。
     TreeMap：基于红黑树的实现。键值对会根据 键值 排序。唯一带有supMap()方法的Map，能返回一个子树。
     WeakHashMap：弱键映射，允许释放映射所指的对象。用于保存WeakReference，在这种映射中，每个值只保存一份实例以节约内存空间。
     IdentityHashMap：使用“==”代替equals()对“键”进行比较的散列映射。
     SortedMap：对键进行排序，通过对象自身 Comparator comparator() 排序

1.5、Queue
     先进先出。通过数组实现。主要操作：add/offer(插入)、remove/poll(移除)、element/peek(检查)，前面方法会抛出异常 / 后面方法会返回特殊值。
     PriorityQueue：优先级队列。插入数据会排列，默认自然顺序，可以使用修改Comparator修改顺序
     BlockingQueue：阻塞队列。支持两种附加操作的队列：在队列为空时，获取元素的线程会等待队列变为非空；当队列满时，存储元素的线程会等待队列可用。

抛出异常

返回特殊值

一直阻塞

超时退出

插入

add(e)

offer(e)

put(e)

offer(e, time, util)

移除

remove()

poll()

take()

poll(time, util)

检查

element()

peek()

无

无

- ArrayBlockingQueue：由数组结构组成的有界阻塞队列。
- LinkedBlockingQueue：由链表结构组成的无界阻塞队列。
- PriorityBlockingQueue：支持优先级排序的无界阻塞队列。
- DelayQueue：使用优先级队列实现的无界阻塞队列。
- SynchronousQueue：不存储元素的阻塞。
- LinkedTransferQueue：由链表结构组成的无界阻塞队列。
- LinkedBlockingDeque：由链表结构组成的双向阻塞队列。

1.6、散列
     数组和链表组合，如 LinkedList [size ]。通过散列函数hash 定义了集合元素和散列表下标之间 多对一的关系。散列表的“槽位”通常称为桶位，为了是散列分布均匀，桶的数量通常使用质数。散列函数算法通常采用 除余散列法、全域散列法、乘法散列法和完全散列法。

1.7、快速报错机制：
     探查容器上的任何除了当前进程所进行的操作以外的所有变化，一旦发现其它进程修改容器。就会抛出 ConcurrentModificationException 异常。 ConcurrentHashMap、CopyOnWriteArrayList和CopyOnWriteArraySet采用这种机制
     工作原理：
     Collection<String> c = new ArrayList<>();
     Iterator<String> iterator = c.iterator();
     c.add("测试");
     try {
          String next = iterator.next();
     } catch (ConcurrentModificationException e) {
         e.printStackTrace();
     }

1.8、持有引用 — Reference
          Reference对象作为你和普通引用的媒介（代理）。使用 Reference 引用的对象，可以继续使用对象，但在内存耗尽时可以释放这个对象。
          三个继承抽象类 Reference 的类，由强到弱：
          SoftReference（软引用）: 内存溢出前进行回收，用于实现内存敏感的高速缓存。可以选择放入ReferenceQueue中。new SoftReference<T>
          WeakReference（弱引用）: 每次GC都会回收，用于实现“规范映射”，不妨碍垃圾回收器回收映射的“键”（或“值”）。可以选择放入ReferenceQueue中。如用于 WeakHashMap。new WeakReference<T>
           PhantomReference（虚引用）:  用于调度回收前的清理工作，比Java终止机制更灵活。依赖ReferenceQueue（用作“回收前清理工作”的工具）.new PhantoReference<T>

二、I/O，NIO
2.1、File 类
     代表一个特定文件的名称，又能代表一个目录下的一组文件的名称。通过 list( ) 或 list(FilenameFilter  filter) 返回字符数组。可以创建新的目录或者不存在的整个目录的路径。可以查看文件的特性，删除文件。

2.2、字节输入/输出

InputStream：用来表示从不同数据源产生输入的类

OutputStream：决定流输出的目标

ByteArrayInputStream：允许将内存的缓存区当做InputStream使用

ByteArrayOutputStream，在内存中创建缓存区，存放所有送往流的数据。

StringBufferInputStream：将String 转为 InputStream。

FileInputStream：用于从文件中读取信息。FileOutputStream，将信息写入文件

PipedInputStream：作为多线程中数据源，实现“管道化”概念。

PipedOutputStream，任何写入的信息都自动作为相关PipedInputStream输出

SequenceInputStream：将多个InputStream对象转为单一InputStream。

FilterInputStream：抽象类、作为“装饰器”的接口

FilterOutputStream，抽象类、作为“装饰器”的接口

DataInputStream：通过可移植方式从流中读取基本数据类型

DataOutStream：通过可移植方式向流中写入数据

BufferedStream：读取数据时使用“缓存区”，通过flush() 清空缓存

BufferedOutStream：发送数据时使用“缓存区”，flush() 清空缓存

2.3、字符输入/输出 Reader 和 Writer
     提供兼容Unicode与面向字符的I/O功能；”适配器”，InputStreamReader 可以把InputStream转换为Reader。
     Java I/O 流类都有相应的 Reader 和 Writer 类。

2.4、I/O 典型用法
     1）缓冲输入文件 ：new BufferedReader(new FileReader(fileName))
     2）从内存中输入：new StringReader("test")
     3）格式化的内存输入：new DataInputStream(new ByteArrayInputStream("test".getBytes()))
     4）基本文件输出：new PrintWriter(new BufferedWriter(new FileWriter("text.txr"))).println("test”);
     5）存储数据：new DataOutputStream( new BufferedOutputStream(new FileOutputStream("data.txt"))).writeDouble(3.1415926)
          恢复数据：new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt"))).readDouble()

2.5、标准I/O
     System.err 、System.out：封装成PrintStream； System.in 使用InputStream
     标准I/O重定向：setIn(InputStream)；setOut(InputStream)；setErr(InputStream)；操作字节流，而不是字符流。

2.6、NIO
     JDK 1.4以后nio包中引入，目的在于提高速度，通过“通道和缓存器”，唯一直接与通道交互的缓存器是ByteBuffer —可以存储未加工字节的缓存器。

2.7、文件加锁
    获取文件锁： FileLock fl=(new FileOutputStream("readme.txt”)).getChannel().tryLock();
    解锁：fl.release()
    注： tryLock() 是非阻塞式的，lock() 是阻塞式的。

2.8、压缩：继承InputStream/OutputStream，因为压缩类库是按照字节方式。
     CheckedInputStream / CheckedOutStream：分别为InputStream/OutStream产生校验和
     DeflaterInputStream / DeflaterOutStream：解压缩类基类 / 压缩类基类
     ZipInputStream / ZipOutStream：解压缩Zip文件格式数据 / 将数据压缩成Zip文件格式
     GZIPInputStream / GZIPOutStream：解压缩GZIP文件格式数据 / 将数据压缩成GZIP文件格式

2.9、序列化
     对象序列化是将实现Serializable 接口的对象转换成一个字节序列。
     Serializable 接口 ： 用于标记对象可序列化。
     Externalizable 接口：继承 Serializable 接口，增加 writerExternal()和readExternal()，在序列化和反序列会调用，可以进行一些特殊处理。
     transient 关键字：修饰的变量，将不再是对象序列化的一部分。只和 Serializable对象一起使用。

2.10、Preferences
     用于小的、受限的数据集合。只存储基本数据类型和字符串，且字符串存储长度不能超过8K。
     键 - 值 集合
     用于存储和读取用户的偏好以及程序配置项的设置。

三、并发
实现多线程方法：继承 Thread 类和实现 Runnable / Callable 接口
3.1、继承 Thread 类
     class SimpleThread extends Thread;
     new SimpleThread().start();

3.2、实现 Runnable 接口 —  无返回值
     class LiftOff implements Runnable
     1）启动
     new Thread(new LiftOff()).start()；
     2）线程池
     CachedThreadPool () ：创建与所需数量相同的线程，然后在回收旧线程时，停止创建新线程。
     FixedThreadPool (n) ：一次性预先创建指定数量的线程放入池中，需要时获取，完成后 放入池中
     SingleThreadPool () ：相当于 FixedThreadPool(1)，多个任务需要排队。保证只有一个任务在执行，可以处理资源共享问题。
     ScheduledThreadPool (min, max) ：创建固定大小的线程池。预先创建min，最多创建 max
     实例：Executors.newCachedThreadPool().execute(new LiftOff())
     参数：

- corePoolSize：线程池中锁保存的核心线程数，包括空闲线程
- maximumPoolSize：池中允许最大线程数
- keepAliveTime：池中空闲线程所能持有的最长时间。
- unit：持续时间单位，TimeUtil 对象
- workQueue：需要执行的队列。BlockingQueue<Runnable>

     线程池一般采用 ArrayBlockingQueue 或 LinkedBlockingQueue 实现

3.3、实现 Callable 接口 — 有返回值 Future<T>
     class TaskWithResult implements Callable<T>
     通过 ExecutorServic.submit() 方法调用，返回 Future<T> 对象。通过 future.isDone() 查询是否完成

3.4、sleep、yield、wait

- sleep：休眠、不释放锁，一定时间内自动唤醒。TimeUnit.MICROSECONDS.sleep(100)
- yield：让出cpu资源，由运行状态变为可运行状态，不释放锁，Thread.yield()。可通过设置优先级，提供获取 CPU 资源概率，Thread.currentThread().setPriority(priority)。
- wait：等待，释放锁，通过notify / notifyAll 方法唤起，进入锁池。wait、notify、notifyAll 都属于 Object 的方法。

3.5、守护线程（后台线程、Daemons线程）

- 程序运行的时候在后台提供一种通用户服务（如gc）的线程。
- 守护线程不属于程序必要线程，当程序所有用户线程结束，程序也会终止，并杀死进程中所有的守护线程；
- thread.setDaemon(true)必须在thread.start()之前设置，否则异常；
- 守护线程中产生的线程也是守护线程。

3.6、join
     sleeper.join() 当前线程等待直到sleeper线程结束才继续执行。
     interrupt() ：中断线程。

3.7、锁
     synchronized：内置锁，悲观锁，操作粒度是“线程”。可对代码块、方法 加锁
     Lock：乐观锁，必须显式创建（Lock lock = new ReentrantLock()）、锁定（lock.lock()）和释放（lock.unlock()）。Lock允许尝试获取但最终未获取锁lock.tryLock(2, TimeUnit.SECONDS)该尝试可以在2s后失败。
     差异：

- Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
- 可释放锁：synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
- 可中断锁：Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
- 查看锁：通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
- 可重入锁：如果锁具备可重入性，则称作为可重入锁。像synchronized和ReentrantLock都是可重入锁，锁的分配机制：基于线程的分配，而不是基于方法调用的分配。
- 公平锁：即尽量以请求锁的顺序来获取锁。synchronized就是非公平锁；ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁，但是可以设置为公平锁。
- 性能：*******

3.8、原子性、可见性、有序性
     1）原子性：不能被线程调度机制中断的操作。如除long和double之外的所有基本数据类型的“简单操作”是原子性操作。
          原子类：AtomicInteger等Atomic前缀的类。
     2）可见性：一个线程修改线程共享变量的值，其它线程能立即得知这个修改。Java内存模型是通过在变量修改后将新值同步回主内存，在变量读取前从主内存刷新变量值这种依赖主内存作为传递媒介的方法来实现可见性的。

- volatile：关键字保证引用的可见性。一个域声明为volatile，只要对这个域写操作，所有读操作都能看到这个操作，即使用处理器缓存，volatile域会立即写入主存中。
- synchronized：对一个变量执行unlock操作之前，必须先把此变量同步回主内存中(执行store和write操作)；
- final：被final修饰的字段是构造器一旦初始化完成，并且构造器没有把“this”引用传递出去，那么在其它线程中就能看见final字段的值。

     3）有序性：程序按代码顺序执行。但 JVM 存在 指令重排序优化和主内存、线程私有内存同步延迟问题，执行过程可能是无序的。volatile、synchronized 关键字保证有序性。

3.9、线程状态：新建、可运行、运行、阻塞、死亡

3.10、死锁
     多个进程因循环等待资源而造成无法执行的现象。死锁产生的4个必要条件：
     1）互斥使用：指进程对所分配到的资源进行排它性使用，即在一段时间内某资源只由一个进程占用；
     2）不可抢占：指进程已获得的资源，在未使用完之前，不能被剥夺，只能在使用完时由自己释放；
     3）请求和保持：指进程已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它进程占有，此时请求进程阻塞，但又对自己已获得的其它资源保持不放；
     4）循环等待：在发生死锁时，必然存在一个进程——资源的环形链，即进程集合{P0，P1，P2，···，Pn}中的P0正在等待一个P1占用的资源；P1正在等待P2占用的资源，……，Pn正在等待已被P0占用的资源。
     死锁避免——银行家算法。

3.11、进程间通信

- 消息传递（管道、FIFO、消息队列）
- 同步（互斥量、条件变量、读写锁、文件和写记录锁、信号量）
- 共享内存（匿名的和具名的）
- 远程过程调用（Solaris门和Sun RPC）

3.12、信号量
信号量是一个确定的二元组（s，q），其中s是一个具有非负初值的整形变量，q是一个初始状态为空的队列，整形变量s表示系统中某类资源的数目：

- 当其值 ≥ 0 时，表示系统中当前可用资源的数目
- 当其值 ＜ 0 时，其绝对值表示系统中因请求该类资源而被阻塞的进程数目

除信号量的初值外，信号量的值仅能由P操作和V操作更改，操作系统利用它的状态对进程和资源进行管理：
     1）P操作：
     P操作记为P(s)，其中s为一信号量，它执行时主要完成以下动作：
     s.value = s.value - 1；  /*可理解为占用1个资源，若原来就没有则记帐“欠”1个*/
     若s.value ≥ 0，则进程继续执行，否则（即s.value < 0），则进程被阻塞，并将该进程插入到信号量s的等待队列s.queue中
     说明：实际上，P操作可以理解为分配资源的计数器，或是使进程处于等待状态的控制指令
     2）V操作：
     V操作记为V(s)，其中s为一信号量，它执行时，主要完成以下动作：
     s.value = s.value + 1；/*可理解为归还1个资源，若原来就没有则意义是用此资源还1个欠帐*/
     若s.value > 0，则进程继续执行，否则（即s.value ≤ 0）,则从信号量s的等待队s.queue中移出第一个进程，使其变为就绪状态，然后返回原进程继续执行
     说明：实际上，V操作可以理解为归还资源的计数器，或是唤醒进程使其处于就绪状态的控制指令

3.13、协程
     协程，又称微线程，纤程。英文名Coroutine。
     协程可以理解为用户级线程，协程和线程的区别是：线程是抢占式的调度，而协程是协同式的调度，协程避免了无意义的调度，由此可以提高性能，但也因此，程序员必须自己承担调度的责任，同时，协程也失去了标准线程使用多CPU的能力。

3.14、同步器
CountDownLatch：同步器，同步一个或者多个任务，强制他们等待有其它任务执行的一组操作完成。无法重复使用。

- public CountDownLatch(int count) {  };  //参数count为计数值
- public void await() throws InterruptedException { };   //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
- public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
- public void countDown() { };  //将count值减1

CyclicBarrier：让一组线程等待某个状态后在全部同时执行。当所有等待线程被释放后，CyclicBarrier 可被重用。 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。

- public CyclicBarrier(int parties) {}; //parties 线程数量
- public CyclicBarrier(int parties, Runnable barrierAction) {}; //parties 线程数量， barrierAction 表示parties个线程都达到barrier状态后执行的操作
- public int await() throws InterruptedException, BrokenBarrierException { };//调用await()方法的线程会被挂起，知道所有线程到到达这个状态
- public int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException { };

Semaphore：控制同时访问的线程个数，通过acquire( )获取许可，release( )释放一个许可。

- public Semaphore(int permits) //参数permits表示许可数目，即同时可以允许多少线程进行访问
- public Semaphore(int permits, boolean fair) //这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
- public void acquire() throws InterruptedException {  } //获取一个许可，若无许可则一直等待
- public void release() { } //释放一个许可。释放许可前必须获取许可
- public boolean tryAcquire() { }; //尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false

DelayQueue：对象到期后才能取走的队列。有序无界的BlockingQueue，用于放置实现了 Delayed接口的对象，不能放置null。内部通过 compareTo( ) 方法排序。
PriorityBlockingQueue：优先级队列，可阻塞的读取操作。
ScheduledExecutor：扩展了 ExecutorService 接口，提供了 时间排程 功能。

- schedule(Callable<V> callable, long delay, TimeUnit unit)  //创建并执行在给定延迟后启用的 ScheduledFuture。
- schedule(Runnable command, long delay, TimeUnit unit)   //创建并执行在给定延迟后启用的一次性操作。
- scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnitunit)  //创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
- scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,TimeUnit unit)  //创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟。

Exchanger：两个任务之间交换对象的栅栏。