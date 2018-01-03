import {Pipe, PipeTransform} from "@angular/core";
import {TeamPlayer} from "../../../models/team-player.model";


@Pipe({ name: 'firstSquadFilter' })
export class FirstSquadFilterPipe implements PipeTransform {
  transform(allPlayers: TeamPlayer[]) {
    // allPlayers.forEach(p=>{
    //   console.log(p.player.name+'->'+p.firstSquad+'=?'+firstSquad);
    // });
    return allPlayers.filter(player=>player.firstSquad);
  }
}
