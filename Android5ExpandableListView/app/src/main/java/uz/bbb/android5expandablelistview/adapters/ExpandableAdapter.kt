package uz.bbb.android5expandablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import uz.bbb.android5expandablelistview.R


class ExpandableAdapter(var titleList: List<String>, var map: HashMap<String, List<String>>) :
    BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosition: Int): String? {
        val list: List<String>? = map[titleList[groupPosition]]
        return list?.get(childPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupItemView: View
        if (convertView == null) {
            groupItemView =
                LayoutInflater.from(parent?.context)
                    .inflate(R.layout.group_item, parent, false)
        } else {
            groupItemView =convertView
        }


        val groupTextView = groupItemView.findViewById<TextView>(R.id.group_tv)

        groupTextView.text = getGroup(groupPosition)

        return groupItemView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): String? {
        return titleList[groupPosition]
    }

    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        var childItemView: View
        if (convertView == null) {
            childItemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.child_item, parent, false)
        } else {
            childItemView = convertView
        }
        val list: List<String>? = map[titleList[groupPosition]]
        val childItem: String? = list?.get(childPosition)
        val childTextView = childItemView.findViewById<TextView>(R.id.child_tv)
        childTextView.text = childItem
        return childItemView
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}