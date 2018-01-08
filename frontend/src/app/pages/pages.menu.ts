import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Home',
    icon: 'nb-home',
    link: 'pages/home',
    home: true,
  },
  {
    title: 'Zespół',
    icon: 'nb-compose',
    link: '/pages/team',
  },
  {
    title: 'Ligi',
    icon: 'nb-person',
    link: '/pages/leagues',
  },
  {
    title: 'Rozgrywka',
    icon: 'nb-person',
    link: '/pages/gameplay',
  },
];
