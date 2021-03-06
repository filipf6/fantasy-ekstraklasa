import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  // {
  //   title: 'Home',
  //   icon: 'nb-home',
  //   link: 'pages/home',
  //   home: true,
  // },
  {
    title: 'Zespół',
    icon: 'nb-compose',
    link: '/pages/team',
    home: true,
  },
  {
    title: 'Ligi',
    icon: 'nb-list',
    link: '/pages/leagues',
  },
  {
    title: 'Rozgrywka',
    icon: 'nb-flame-circled',
    link: '/pages/gameplay',
  },
];
