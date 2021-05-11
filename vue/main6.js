// 按需引入 Element
import Vue from 'vue'
import { Button, Select } from 'element-ui'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'

// 设置语言
locale.use(lang)

// 引入组件
Vue.component(Button.name, Button)
Vue.component(Select.name, Select)