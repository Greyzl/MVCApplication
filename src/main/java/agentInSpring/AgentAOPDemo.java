package agentInSpring;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);

        Agent proxy = (Agent)proxyFactory.getProxy();
        proxy.speak();
    }
}
