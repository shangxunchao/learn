package com.qiandao.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动举办方 组织结构
 */
public class VipkidOrg {
    public static List<Org> orgs = new ArrayList<Org>();
    public static List<Org> orgsChild = new ArrayList<Org>();

    static {
        orgsChild.add(new Org(2, "公关部", 1, null));
        orgsChild.add(new Org(3, "市场部", 1, null));
        orgsChild.add(new Org(4, "校园事业部", 1, null));
        orgs.add(new Org(1, "市场中心", 0, orgsChild));

        orgsChild.clear();
        orgsChild.add(new Org(6, "用户运营部", 5, null));
        orgs.add(new Org(5, "LP", 0, orgsChild));

        orgsChild.clear();
        orgs.add(new Org(7, "创新业务中心", 0, null));

        orgsChild.clear();
        orgsChild.add(new Org(9, "运营部", 8, null));
        orgsChild.add(new Org(10, "教研部", 8, null));
        orgsChild.add(new Org(11, "产品部", 8, null));
        orgs.add(new Org(8, "教育产品中心EDUC", 0, orgsChild));
    }

    public static class Org {
        private int id;
        private String name;
        private int parentId;
        private List<Org> children;

        public Org(int id, String name, int parentId, List<Org> children) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
            if (children != null) {
                this.children = new ArrayList<Org>(children);
            } else {
                this.children = null;
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public List<Org> getChildren() {
            return children;
        }

        public void setChildren(List<Org> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Org{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", parentId=" + parentId +
                    '}';
        }
    }
}
