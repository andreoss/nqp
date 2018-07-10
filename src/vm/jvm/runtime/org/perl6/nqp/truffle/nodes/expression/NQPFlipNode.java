package org.perl6.nqp.truffle.nodes.expression;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import org.perl6.nqp.truffle.nodes.NQPNode;
import org.perl6.nqp.truffle.nodes.NQPStrNode;
import org.perl6.nqp.dsl.Deserializer;

@NodeInfo(shortName = "flip")
public final class NQPFlipNode extends NQPStrNode {
    @Child private NQPNode argNode;

    @Deserializer
    public NQPFlipNode(NQPNode argNode) {
        this.argNode = argNode;
    }

    @Override
    public String executeStr(VirtualFrame frame) {
        return new StringBuffer(argNode.executeStr(frame)).reverse().toString();
    }
}
