package so.wwb.creditbox.service.manager.taskschedule.factory;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 同步的任务工厂类
 * @author: marz
 * @time 2018-3-2 20:35:57
 */

/**
 * Quartz定时任务默认都是并发执行的，不会等待上一次任务执行完毕，只要间隔时间到就会执行, 如果定时任执行太长，会长时间占用资源，导致其它任务堵塞。
 1.在Spring中这时需要设置concurrent的值为false, 禁止并发执行。
 <property name="concurrent" value="true" />
 2.当不使用spring的时候就需要在Job的实现类上加@DisallowConcurrentExecution的注释
 @DisallowConcurrentExecution 禁止并发执行多个相同定义的JobDetail, 这个注解是加在Job类上的, 但意思并不是不能同时执行多个Job,
 而是不能并发执行同一个Job Definition(由JobDetail定义), 但是可以同时执行多个不同的JobDetail, 举例说明,我们有一个Job类,叫做SayHelloJob,
 并在这个Job上加了这个注解, 然后在这个Job上定义了很多个JobDetail, 如sayHelloToJoeJobDetail, sayHelloToMikeJobDetail, 那么当scheduler启动时,
 不会并发执行多个sayHelloToJoeJobDetail或者sayHelloToMikeJobDetail, 但可以同时执行sayHelloToJoeJobDetail跟sayHelloToMikeJobDetail
 @PersistJobDataAfterExecution 同样, 也是加在Job上,表示当正常执行完Job后, JobDataMap中的数据应该被改动, 以被下一次调用时用。
 当使用@PersistJobDataAfterExecution 注解时, 为了避免并发时, 存储数据造成混乱, 强烈建议把@DisallowConcurrentExecution注解也加上。
 @DisallowConcurrentExecution
 此标记用在实现Job的类上面,意思是不允许并发执行,按照我之前的理解是 不允许调度框架在同一时刻调用Job类，后来经过测试发现并不是这样，
 而是Job(任务)的执行时间[比如需要10秒]大于任务的时间间隔 [Interval（5秒)],那么默认情况下,调度框架为了能让 任务按照我们预定的时间间隔执行,
 会马上启用新的线程执行任务。否则的话会等待任务执行完毕以后 再重新执行！（这样会导致任务的执行不是按照我们预先定义的时间间隔执行）
 测试代码，这是官方提供的例子。设定的时间间隔为3秒,但job执行时间是5秒,设置@DisallowConcurrentExecution以后程序会等任务执行完毕以后再去执行,否则会在3秒时再启用新的线程执行
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class JobSyncFactory extends AbstractJobFactory {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        run(context);
    }
}
