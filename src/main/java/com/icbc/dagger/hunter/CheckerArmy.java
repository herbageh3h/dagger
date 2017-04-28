package com.icbc.dagger.hunter;

import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.AntChecker;
import com.icbc.dagger.hunter.checker.AntlrChecker;
import com.icbc.dagger.hunter.checker.AopallianceChecker;
import com.icbc.dagger.hunter.checker.AsmChecker;
import com.icbc.dagger.hunter.checker.AxiomChecker;
import com.icbc.dagger.hunter.checker.AxisChecker;
import com.icbc.dagger.hunter.checker.BatisChecker;
import com.icbc.dagger.hunter.checker.CglibChecker;
import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.checker.CommonsChecker;
import com.icbc.dagger.hunter.checker.CtpcoreChecker;
import com.icbc.dagger.hunter.checker.CxfChecker;
import com.icbc.dagger.hunter.checker.Dom4jChecker;
import com.icbc.dagger.hunter.checker.EdtftpjChecker;
import com.icbc.dagger.hunter.checker.FastjsonChecker;
import com.icbc.dagger.hunter.checker.GuavaChecker;
import com.icbc.dagger.hunter.checker.HttpComponentsChecker;
import com.icbc.dagger.hunter.checker.IbmmqChecker;
import com.icbc.dagger.hunter.checker.JSqlParserChecker;
import com.icbc.dagger.hunter.checker.JacksonChecker;
import com.icbc.dagger.hunter.checker.JavassistChecker;
import com.icbc.dagger.hunter.checker.JaxbChecker;
import com.icbc.dagger.hunter.checker.JaxenChecker;
import com.icbc.dagger.hunter.checker.JbpmChecker;
import com.icbc.dagger.hunter.checker.JcommonChecker;
import com.icbc.dagger.hunter.checker.JdomChecker;
import com.icbc.dagger.hunter.checker.JedisChecker;
import com.icbc.dagger.hunter.checker.JettyChecker;
import com.icbc.dagger.hunter.checker.JfreechartChecker;
import com.icbc.dagger.hunter.checker.JmxChecker;
import com.icbc.dagger.hunter.checker.JschChecker;
import com.icbc.dagger.hunter.checker.JsonChecker;
import com.icbc.dagger.hunter.checker.JxlChecker;
import com.icbc.dagger.hunter.checker.Log4jChecker;
import com.icbc.dagger.hunter.checker.MsvChecker;
import com.icbc.dagger.hunter.checker.Mvel2Checker;
import com.icbc.dagger.hunter.checker.Mx4jChecker;
import com.icbc.dagger.hunter.checker.NcsoChecker;
import com.icbc.dagger.hunter.checker.NeethiChecker;
import com.icbc.dagger.hunter.checker.NettyChecker;
import com.icbc.dagger.hunter.checker.OpencsvChecker;
import com.icbc.dagger.hunter.checker.PoiChecker;
import com.icbc.dagger.hunter.checker.QuartzChecker;
import com.icbc.dagger.hunter.checker.RelaxngChecker;
import com.icbc.dagger.hunter.checker.RhinoChecker;
import com.icbc.dagger.hunter.checker.SaxpathChecker;
import com.icbc.dagger.hunter.checker.SdoChecker;
import com.icbc.dagger.hunter.checker.Slf4jChecker;
import com.icbc.dagger.hunter.checker.SpringChecker;
import com.icbc.dagger.hunter.checker.SslChecker;
import com.icbc.dagger.hunter.checker.StaxChecker;
import com.icbc.dagger.hunter.checker.StrutsChecker;
import com.icbc.dagger.hunter.checker.UeditorChecker;
import com.icbc.dagger.hunter.checker.VelocityChecker;
import com.icbc.dagger.hunter.checker.Wsdl4jChecker;
import com.icbc.dagger.hunter.checker.XStreamChecker;
import com.icbc.dagger.hunter.checker.XalanChecker;
import com.icbc.dagger.hunter.checker.XmlbeanChecker;
import com.icbc.dagger.hunter.checker.XmlresolverChecker;
import com.icbc.dagger.hunter.checker.XmlschemaChecker;
import com.icbc.dagger.hunter.checker.ZookeeperChecker;
import com.icbc.dagger.hunter.checker.ZxingChecker;

public class CheckerArmy {
    private List<Checker> jarCheckerList;

    public List<Checker> jarCheckers() {
        if (jarCheckerList != null) {
            return jarCheckerList;
        }

        jarCheckerList = new ArrayList<Checker>();

        jarCheckerList.add(new FastjsonChecker());
        jarCheckerList.add(new JacksonChecker());
        jarCheckerList.add(new StrutsChecker());
        jarCheckerList.add(new BatisChecker());
        jarCheckerList.add(new JbpmChecker());
        jarCheckerList.add(new SpringChecker());
        jarCheckerList.add(new JaxenChecker());
        jarCheckerList.add(new JdomChecker());
        jarCheckerList.add(new Dom4jChecker());
        jarCheckerList.add(new CxfChecker());
        jarCheckerList.add(new VelocityChecker());
        jarCheckerList.add(new Slf4jChecker());
        jarCheckerList.add(new PoiChecker());
        jarCheckerList.add(new JfreechartChecker());
        jarCheckerList.add(new Log4jChecker());
        jarCheckerList.add(new JettyChecker());
        jarCheckerList.add(new CommonsChecker());
        jarCheckerList.add(new JedisChecker());
        jarCheckerList.add(new AntChecker());
        jarCheckerList.add(new JxlChecker());
        jarCheckerList.add(new HttpComponentsChecker());
        jarCheckerList.add(new AntlrChecker());
        jarCheckerList.add(new AopallianceChecker());
        jarCheckerList.add(new AsmChecker());
        jarCheckerList.add(new AxiomChecker());
        jarCheckerList.add(new AxisChecker());
        jarCheckerList.add(new CglibChecker());
        jarCheckerList.add(new EdtftpjChecker());
        jarCheckerList.add(new JavassistChecker());
        jarCheckerList.add(new JcommonChecker());
        jarCheckerList.add(new RhinoChecker());
        jarCheckerList.add(new JschChecker());
        jarCheckerList.add(new JSqlParserChecker());
        jarCheckerList.add(new Mvel2Checker());
        jarCheckerList.add(new Mx4jChecker());
        jarCheckerList.add(new NcsoChecker());
        jarCheckerList.add(new NeethiChecker());
        jarCheckerList.add(new NettyChecker());
        jarCheckerList.add(new OpencsvChecker());
        jarCheckerList.add(new SdoChecker());
        jarCheckerList.add(new StaxChecker());
        jarCheckerList.add(new Wsdl4jChecker());
        jarCheckerList.add(new XalanChecker());
        jarCheckerList.add(new XmlbeanChecker());
        jarCheckerList.add(new ZxingChecker());
        jarCheckerList.add(new XStreamChecker());
        jarCheckerList.add(new XmlschemaChecker());
        jarCheckerList.add(new XmlresolverChecker());
        jarCheckerList.add(new JsonChecker());
        jarCheckerList.add(new UeditorChecker());
        jarCheckerList.add(new IbmmqChecker());
        jarCheckerList.add(new JaxbChecker());
        jarCheckerList.add(new JmxChecker());
        jarCheckerList.add(new QuartzChecker());
        jarCheckerList.add(new MsvChecker());
        jarCheckerList.add(new SaxpathChecker());
        jarCheckerList.add(new RelaxngChecker());
        jarCheckerList.add(new SslChecker());
        jarCheckerList.add(new CtpcoreChecker());
        jarCheckerList.add(new GuavaChecker());
        jarCheckerList.add(new ZookeeperChecker());

        return jarCheckerList;
    }

}
