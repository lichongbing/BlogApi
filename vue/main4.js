/**
 * 全局配置  按需引入 Element：
 */

import Vue from 'vue';
import { Button } from 'element-ui';

Vue.prototype.$ELEMENT = { size: 'small', zIndex: 3000 };
Vue.use(Button);